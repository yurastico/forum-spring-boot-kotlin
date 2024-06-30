package com.yurastico.forum.config

import com.yurastico.forum.security.AppAuthenticationManager
import com.yurastico.forum.security.JWTAuthenticationFilter
import com.yurastico.forum.security.JWTLoginFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.OncePerRequestFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userDetailsService: UserDetailsService,
    private val jwtUtil: JWTUtil,
    private val authenticationConfiguration: AuthenticationConfiguration,
    private val authenticationManager: AppAuthenticationManager
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .csrf { c -> c.disable() }
            .authorizeHttpRequests { r -> r.requestMatchers(HttpMethod.POST,"/login").permitAll().anyRequest().authenticated() }
        http.addFilterBefore(JWTLoginFilter(authenticationManager = authenticationManager, jwtUtil = jwtUtil),UsernamePasswordAuthenticationFilter::class.java)
        .addFilterBefore(JWTAuthenticationFilter(jwtUtil = jwtUtil),UsernamePasswordAuthenticationFilter::class.java)
        http.sessionManagement { s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

        return http.build()
    }

}