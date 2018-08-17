package com.mohamadk.hotelspring.security

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.InjectMocks


class JWTTokenValidatorTest: BaseJwtTokenTest() {

    @InjectMocks
    private val jwtValidator: JwtValidator? = null

    @Test
    @Throws(Exception::class)
    fun generateTokenTest() {

        val jwtUser = jwtValidator!!.validate(removePrefix(TEST_TOKEN))

        assertEquals(jwtUser,createJwtUser())
    }


}