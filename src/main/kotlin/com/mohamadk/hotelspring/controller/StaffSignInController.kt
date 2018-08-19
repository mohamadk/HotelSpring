package com.mohamadk.hotelspring.controller

import com.mohamadk.hotelspring.exceptions.AuthenticationException
import com.mohamadk.hotelspring.model.JwtAuthenticationToken
import com.mohamadk.hotelspring.model.Staff
import com.mohamadk.hotelspring.security.JwtGenerator
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StaffSignInController {

    val logger = LoggerFactory.getLogger(HelloController::class.java)

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var jwtGenerator: JwtGenerator

    @PostMapping("/signIn")
    fun generate(@RequestBody staff: Staff): String {
        logger.debug("staff=${staff}")

        authenticate(staff)

        return jwtGenerator.generate(staff)
    }

    private fun authenticate(staff: Staff) {
        try {
            authenticationManager.authenticate(JwtAuthenticationToken(principal = staff.userName, credential = staff.password))
        } catch (e: DisabledException) {
            throw AuthenticationException("User is disabled!", e)
        } catch (e: BadCredentialsException) {
            throw AuthenticationException("Bad credentials!", e)
        }
    }


}