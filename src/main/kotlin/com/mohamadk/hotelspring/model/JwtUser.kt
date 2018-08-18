package com.mohamadk.hotelspring.model

data class JwtUser(var userName: String
                   , var id: Long = 0
                   , var role: String? = null){

    companion object {
        fun fill(staff: Staff): JwtUser {
            return JwtUser(staff.userName,staff.id,staff.role)
        }
    }
}
