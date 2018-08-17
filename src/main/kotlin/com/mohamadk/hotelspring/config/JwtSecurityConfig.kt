package com.mohamadk.hotelspring.config

import com.mohamadk.hotelspring.security.JwtAuthenticationEntryPoint
import com.mohamadk.hotelspring.security.JwtAuthenticationProvider
import com.mohamadk.hotelspring.security.JwtAuthenticationTokenFilter
import com.mohamadk.hotelspring.security.JwtSuccessHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class JwtSecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var entryPoint: JwtAuthenticationEntryPoint

    @Bean
    fun authenticationTokenFilter(): JwtAuthenticationTokenFilter {
        val filter = JwtAuthenticationTokenFilter()
        filter.setAuthenticationManager(authenticationManager())
        filter.setAuthenticationSuccessHandler(JwtSuccessHandler())

        return filter
    }

    @Autowired
    lateinit var authenticationProvider: JwtAuthenticationProvider

    @Bean
    override fun authenticationManager(): AuthenticationManager {

        return ProviderManager(Collections.singletonList(authenticationProvider) as List<AuthenticationProvider>?)
    }

    override fun configure(http: HttpSecurity?) {


        http!!.csrf().disable()
                .authorizeRequests().antMatchers("**/rest/**").authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http!!.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)

        http.headers().cacheControl()


    }


}