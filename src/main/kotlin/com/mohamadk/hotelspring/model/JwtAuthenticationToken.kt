package com.mohamadk.hotelspring.model

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class JwtAuthenticationToken(var token: String? = null, principal: Any? = null, credential: Any? = null)
    : UsernamePasswordAuthenticationToken(principal, credential) {


}
