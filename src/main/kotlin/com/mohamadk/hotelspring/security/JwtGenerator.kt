package com.mohamadk.hotelspring.security

import com.mohamadk.hotelspring.model.Staff
import com.mohamadk.hotelspring.security.JwtAuthenticationTokenFilter.Companion.TOKEN_PREFIX
import com.mohamadk.hotelspring.security.JwtValidator.Companion.SECRET_KEY
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component

@Component
class JwtGenerator {
    fun generate(staff: Staff): String {

        val claim = Jwts.claims()
                .setSubject(staff.userName)

        claim.put("userId", "${staff.id}")
        claim.put("role", staff.role)

        val bytes=Decoders.BASE64.decode(SECRET_KEY)
        val key= Keys.hmacShaKeyFor(bytes)

        return "$TOKEN_PREFIX${Jwts.builder()
                .setClaims(claim)
                .signWith(key)
                .compact()
        }"

    }

}
