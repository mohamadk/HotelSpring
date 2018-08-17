package com.mohamadk.hotelspring.security

import com.mohamadk.hotelspring.model.JwtAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationTokenFilter : AbstractAuthenticationProcessingFilter("/rest/**") {

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val token: String? = request!!.getHeader("Authorization")


        if (token == null || !token.startsWith(TOKEN_PREFIX)) {
                throw RuntimeException("Jwt token Is missing")
        }

        val authenticationToken = token.substring(TOKEN_PREFIX.length)

        val jwtAuthenticationToken = JwtAuthenticationToken(authenticationToken)

        return authenticationManager.authenticate(jwtAuthenticationToken)
    }


    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, chain: FilterChain?, authResult: Authentication?) {
        super.successfulAuthentication(request, response, chain, authResult)
        chain!!.doFilter(request, response)
    }

    companion object {
        val TOKEN_PREFIX = "Bearer "
    }
}
