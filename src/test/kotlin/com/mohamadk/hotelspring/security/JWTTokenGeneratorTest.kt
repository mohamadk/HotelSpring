package com.mohamadk.hotelspring.security

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.InjectMocks


class JWTTokenGeneratorTest : BaseJwtTokenTest() {

    @InjectMocks
    private val jwtGenerator: JwtGenerator? = null

    @Test
    @Throws(Exception::class)
    fun generateTokenTest() {

//        val token = jwtGenerator!!.generate(createJwtUser())

//        assertEquals(token, TEST_TOKEN)
    }

}