package com.mohamadk.hotelspring.model

data class JwtUser (var userName: String,
               var id: Long=0,
               var role: String?=null){
}
