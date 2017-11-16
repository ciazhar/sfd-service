package com.ciazhar.sfdservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.HttpSecurity
import org.springframework.security.core.userdetails.MapUserDetailsRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsRepository
import org.springframework.security.web.server.SecurityWebFilterChain





/**
 * Created by ciazhar on 11/12/17.
 *
 * [ Documentation Here ]
 */
@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun userDetailsRepository(): UserDetailsRepository {
        val admin = User.withUsername("admin").password("123").roles("ADMIN").build()
        val ciazhar = User.withUsername("ciazhar").password("123").roles("USER").build()

        return MapUserDetailsRepository(admin, ciazhar)
    }

    @Bean
    @Throws(Exception::class)
    fun springWebFilterChain(http: HttpSecurity): SecurityWebFilterChain {
        return http
            .authorizeExchange()
            .pathMatchers("/","/css/**","/js/**","/img/**","/vendor/**").permitAll()
            .pathMatchers("/**").hasRole("ADMIN")
            .anyExchange().authenticated()
            .and()
            .build()
    }
}