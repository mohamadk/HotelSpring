package com.mohamadk.hotelspring.model

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class JwtAuthenticationToken (var token:String,principal:Any?=null,credential:Any?=null)
    : UsernamePasswordAuthenticationToken(principal,credential) {



    override fun getCredentials(): Any?{
        return null
    }

    override fun getPrincipal(): Any? {
        return null
    }

}
