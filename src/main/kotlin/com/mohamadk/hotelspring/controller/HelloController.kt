package com.mohamadk.hotelspring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController{

    @GetMapping("/rest/hello")
    fun hello(): String {
        return "hello world"
    }
}