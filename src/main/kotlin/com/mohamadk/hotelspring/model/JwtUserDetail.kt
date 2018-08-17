package com.mohamadk.hotelspring.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class JwtUserDetail(
        val myUserName: String
        , val id: Long
        , val token: String
        , val grantedAuthoritys: MutableCollection<GrantedAuthority>
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return grantedAuthoritys
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return myUserName
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return ""
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }


}
