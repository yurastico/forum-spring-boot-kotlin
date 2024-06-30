package com.yurastico.forum.config

import com.yurastico.forum.model.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.annotation.PostConstruct
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JWTUtil(
    private val userDetailsService: UserDetailsService
) {
    companion object {
        private const val expiration: Long = 60000
    }

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    private var key: SecretKey? = null

    @PostConstruct
    fun init() {

        key = Keys.hmacShaKeyFor(secret.toByteArray())
    }


    fun generateToken(username: String): String? {
        val key = Keys.hmacShaKeyFor(secret.toByteArray())
        return Jwts.builder()
            .subject(username)
            .expiration(Date(System.currentTimeMillis() + expiration))
            .signWith(key)
            .compact()
    }

    fun isValid(jwt: String?): Boolean {
        return try {
            val claims =  Jwts.parser().verifyWith(key)
                .clockSkewSeconds(3 * 60)
                .build()
                .parseSignedClaims(jwt?.replace("Bearer ", "") )

            true

        } catch (e: IllegalArgumentException) {
            false
        }
    }

    fun getAuthentication(jwt: String?): Authentication {
        val claims = Jwts.parser()
            .verifyWith(key)
            .clockSkewSeconds(3 * 60)
            .build()
            .parseSignedClaims(jwt?.replace("Bearer ", ""))

        return UsernamePasswordAuthenticationToken(claims, null, null)

    }
}

