package com.mohamadk.hotelspring.security

import com.mohamadk.hotelspring.model.JwtAuthenticationToken
import com.mohamadk.hotelspring.model.JwtUserDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class JwtAuthenticationProvider : AbstractUserDetailsAuthenticationProvider() {

    @Autowired
    lateinit var jwtValidator:JwtValidator


    override fun retrieveUser(username: String?, authentication: UsernamePasswordAuthenticationToken?): UserDetails {
        val token =(authentication as JwtAuthenticationToken).token

        val jwtUser=jwtValidator.validate(token)

        val grantedAuthoritys:MutableCollection<GrantedAuthority> =AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.role)
        val jwtUserDetail= JwtUserDetail(jwtUser.userName,jwtUser.id,token,grantedAuthoritys)

        return jwtUserDetail
    }

    override fun additionalAuthenticationChecks(userDetails: UserDetails?, authentication: UsernamePasswordAuthenticationToken?) {

    }


    override fun supports(authentication: Class<*>?): Boolean {
        return authentication!!.isAssignableFrom(JwtAuthenticationToken::class.java)
    }

}
