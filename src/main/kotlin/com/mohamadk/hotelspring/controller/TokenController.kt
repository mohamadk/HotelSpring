package com.mohamadk.hotelspring.controller

import com.mohamadk.hotelspring.model.JwtUser
import com.mohamadk.hotelspring.security.JwtGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
class TokenController{

    @Autowired
    lateinit var jwtGenerator:JwtGenerator

    @PostMapping("/token")
    fun generate(@RequestBody user: JwtUser): String {
        return jwtGenerator.generate(user)
    }


}