package com.mohamadk.hotelspring.security

import com.mohamadk.hotelspring.model.JwtAuthenticationToken
import com.mohamadk.hotelspring.security.JwtAuthenticationTokenFilter.Companion.TOKEN_HEADER_KEY
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.core.Authentication
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationTokenFilterTest : BaseJwtTokenTest() {



    @Test
    fun attemptAuthenticationTest() {

        val jwtAuthenticationTokenFilterSpy=Mockito.spy(JwtAuthenticationTokenFilter())
        val manager = mock(ProviderManager::class.java)

        `when`(manager.authenticate(ArgumentMatchers.any())).thenReturn(mock(Authentication::class.java))

        jwtAuthenticationTokenFilterSpy.setAuthenticationManager(manager)
        val httpServletRequest=mock(HttpServletRequest::class.java)
        val httpServletResponse=mock(HttpServletResponse::class.java)

        `when`(httpServletRequest.getHeader(TOKEN_HEADER_KEY)).thenReturn(TEST_TOKEN)

        jwtAuthenticationTokenFilterSpy.attemptAuthentication(httpServletRequest,httpServletResponse)

        verify(manager.authenticate(JwtAuthenticationToken(removePrefix(TEST_TOKEN))), times(1))

    }



}