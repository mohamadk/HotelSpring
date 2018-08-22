package com.mohamadk.hotelspring.exceptions

class AuthenticationException(message: String, cause: Throwable? = null) : RuntimeException(message, cause) {
    companion object {
        const val TOKEN_IS_MISSING = "Jwt token Is missing"
        const val TOKEN_IS_INCORRECT = "Jwt token is incorrect"
    }
}
