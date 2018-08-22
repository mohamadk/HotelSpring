package com.mohamadk.hotelspring.security

import com.mohamadk.hotelspring.model.JwtUser
import com.mohamadk.hotelspring.model.Staff
import org.junit.Before
import org.mockito.MockitoAnnotations

open class BaseJwtTokenTest {
    internal val TEST_USERNAME = "testUser"
    internal val TEST_ID = 1L
    internal val TEST_ROLE = "ADMIN"
    internal val TEST_TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0VXNlciIsInVzZXJJZCI6IjEiLCJyb2xlIjoiQURNSU4ifQ.WLb4_qWm8DYd-9zP1njRkzQSnZhEm1W9GDlrlApNu2JrgRTuo4QZz-JrXy01eAzb8F5ztf8qc8mdy2zSniMbHg"


    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    internal fun createJwtUser(): JwtUser {
        return JwtUser(TEST_USERNAME, TEST_ID, TEST_ROLE)
    }
    internal fun createStaff(): Staff {
        val staff=Staff(userName = TEST_USERNAME,role = TEST_ROLE)
        staff.id=TEST_ID

        return staff
    }

    internal fun removePrefix(token: String): String {
        return token.substring(JwtAuthenticationTokenFilter.TOKEN_PREFIX.length)
    }

}