package com.mohamadk.hotelspring.security

import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtSuccessHandler : AuthenticationSuccessHandler {
    val logger = LoggerFactory.getLogger(JwtSuccessHandler::class.java)
    override fun onAuthenticationSuccess(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {

        logger.info("Successful Authentication.")
    }

}
