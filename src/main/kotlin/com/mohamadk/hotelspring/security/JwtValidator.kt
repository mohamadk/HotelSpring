package com.mohamadk.hotelspring.security

import com.mohamadk.hotelspring.model.JwtUser
import io.jsonwebtoken.Jwts
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class JwtValidator {
    val logger=LoggerFactory.getLogger(JwtValidator::class.java)

    fun validate(token: String): JwtUser {

        try {
            val body = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .body

            return JwtUser(
                    body.subject,
                    (body.get("userId") as String).toLong(),
                    body.get("role") as String?
            )

        } catch (e: Exception) {
            logger.info("Jwt token is incorrect",e)
            throw RuntimeException("Jwt token is incorrect")
        }
    }

    companion object {
        val SECRET_KEY = "mySecretKey12135466468746864646468465mySecretKey12135466468746864646468465mySecretKey12135466468746864646468465"
    }
}
