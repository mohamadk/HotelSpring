package com.mohamadk.hotelspring.security

import com.mohamadk.hotelspring.model.JwtUser
import com.mohamadk.hotelspring.security.JwtAuthenticationTokenFilter.Companion.TOKEN_PREFIX
import com.mohamadk.hotelspring.security.JwtValidator.Companion.SECRET_KEY
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.security.Key

@Component
class JwtGenerator {
    fun generate(user: JwtUser): String {

        val claim = Jwts.claims()
                .setSubject(user.userName)

        claim.put("userId", "${user.id}")
        claim.put("role", user.role)

        val bytes=Decoders.BASE64.decode(SECRET_KEY)
        val key= Keys.hmacShaKeyFor(bytes)

        return "$TOKEN_PREFIX${Jwts.builder()
                .setClaims(claim)
                .signWith(key)
                .compact()
        }"

    }

}
