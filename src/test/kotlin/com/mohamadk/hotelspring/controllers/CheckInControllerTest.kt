package com.mohamadk.hotelspring.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.mohamadk.hotelspring.controller.CheckInController
import com.mohamadk.hotelspring.model.Guest
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers.containsString
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
open class CheckInControllerTest {
    @Autowired
    lateinit var controller: CheckInController

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun contextLoads() {
        assertThat(controller).isNotNull
    }

    @Test
    @Throws(Exception::class)
    fun testCheckInController() {
      checkIn(mockMvc)
                .andDo(print()).andExpect(status().isOk)
                .andExpect(content().string(containsString("true")))
    }

    companion object {
        fun createGuest(): Guest {
            return Guest("mk${Random().nextInt()}", "mohamad", "khaleghy")
        }

        fun checkIn(mockMvc: MockMvc): ResultActions {
            return mockMvc.perform(
                    post("/checkIn")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(ObjectMapper().writeValueAsBytes(createGuest()))
            )
        }

    }
}

