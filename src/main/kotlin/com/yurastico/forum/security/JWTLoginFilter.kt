package com.yurastico.forum.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.yurastico.forum.config.JWTUtil
import com.yurastico.forum.model.Credentials
import com.yurastico.forum.service.UserDetail
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class JWTLoginFilter(
    private val jwtUtil: JWTUtil,
   private val authenticationManager: AuthenticationManager
) : UsernamePasswordAuthenticationFilter()
{
    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val (username, password) = ObjectMapper().readValue(request?.inputStream, Credentials::class.java)
        val token = UsernamePasswordAuthenticationToken(username,password)
        return authenticationManager.authenticate(token)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {

        val token = authResult?.let { jwtUtil.generateToken(it.name) }
        response?.addHeader("Authorization", "Bearer $token")
    }
}
