package com.mohamadk.hotelspring.security

import com.mohamadk.hotelspring.exceptions.UserNotFoundException
import com.mohamadk.hotelspring.model.JwtAuthenticationToken
import com.mohamadk.hotelspring.model.JwtUser
import com.mohamadk.hotelspring.model.JwtUserDetail
import com.mohamadk.hotelspring.repository.StaffRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class JwtAuthenticationProvider : AbstractUserDetailsAuthenticationProvider() {

    @Autowired
    lateinit var jwtValidator: JwtValidator

    @Autowired
    lateinit var staffRepository: StaffRepository

    @Autowired
    lateinit var generator: JwtGenerator

    override fun retrieveUser(username: String?, authentication: UsernamePasswordAuthenticationToken?): UserDetails {

        val jwtAuthenticationToken = (authentication as JwtAuthenticationToken)

        val jwtUser: JwtUser
        val token: String
        if (jwtAuthenticationToken.token != null) {
            token = jwtAuthenticationToken.token!!
            jwtUser = jwtValidator.validate(token)
        } else {//login
            try {
                val staff = staffRepository.findUser(jwtAuthenticationToken.principal as String, jwtAuthenticationToken.credentials as String)
                jwtUser = JwtUser.fill(staff)
                token = generator.generate(staff)
            } catch (e: EmptyResultDataAccessException) {
                throw UserNotFoundException("user not found !", e)
            }
        }

        val grantedAuthoritys: MutableCollection<GrantedAuthority> = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.role)
        val jwtUserDetail = JwtUserDetail(jwtUser.userName, jwtUser.id, token, grantedAuthoritys)
        return jwtUserDetail
    }

    override fun additionalAuthenticationChecks(userDetails: UserDetails?, authentication: UsernamePasswordAuthenticationToken?) {

    }


    override fun supports(authentication: Class<*>?): Boolean {
        return authentication!!.isAssignableFrom(JwtAuthenticationToken::class.java)
    }

}
