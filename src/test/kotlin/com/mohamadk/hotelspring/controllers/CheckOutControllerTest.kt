package com.mohamadk.hotelspring.controllers

import com.mohamadk.hotelspring.exceptions.AuthenticationException
import com.mohamadk.hotelspring.controller.CheckOutController
import org.assertj.core.api.Assertions
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


class CheckOutControllerTest : CheckInControllerTest() {
    internal val TEST_TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0VXNlciIsInVzZXJJZCI6IjEiLCJyb2xlIjoiQURNSU4ifQ.WLb4_qWm8DYd-9zP1njRkzQSnZhEm1W9GDlrlApNu2JrgRTuo4QZz-JrXy01eAzb8F5ztf8qc8mdy2zSniMbHg"

    @Autowired
    lateinit var checkOutController: CheckOutController

    @Test
    @Throws(Exception::class)
    fun checkOutContexLoads() {
        Assertions.assertThat(checkOutController).isNotNull
    }

    @Test
    @Throws(Exception::class)
    fun wellInput() {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/rest/checkOut/1")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .header("Authorization", TEST_TOKEN)

        )
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString("false")))
    }

    @Test
    @Throws(Exception::class)
    fun withoutAuthorizationToken() {
        Assertions.assertThatThrownBy {
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/rest/checkOut/1")
                            .contentType(MediaType.APPLICATION_FORM_URLENCODED)

            )
                    .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk)
                    .andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString("false")))
        }.hasCauseExactlyInstanceOf(AuthenticationException::class.java)
                .hasMessage(AuthenticationException.TOKEN_IS_MISSING)

    }

}