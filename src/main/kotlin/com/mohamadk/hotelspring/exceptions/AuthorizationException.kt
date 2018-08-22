package com.mohamadk.hotelspring.exceptions

class AuthorizationException(message: String, cause: Throwable? = null) : RuntimeException(message, cause) {
    companion object {
        const val USER_IS_DISABLED = "User is disabled!"
        const val BAD_CREDENTIAL = "Bad credentials!"
    }
}