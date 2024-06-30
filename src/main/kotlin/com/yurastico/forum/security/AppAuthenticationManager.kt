package com.yurastico.forum.security
import com.yurastico.forum.model.User
import com.yurastico.forum.repository.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component



@Component
class AppAuthenticationManager(
    private val userRepository: UserRepository,
    val bCryptPasswordEncoder: BCryptPasswordEncoder,
) : AuthenticationManager {
    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication {
        val password = authentication.credentials.toString()
        val user: User = userRepository.findByEmail(authentication.name) ?: throw UsernameNotFoundException("username not found")
        if (!bCryptPasswordEncoder.matches(password, user.password)) {
            throw BadCredentialsException("Bad credentials")
        }
        val authorities = ArrayList<GrantedAuthority>()
        user.role.forEach { authorities.add(SimpleGrantedAuthority(it.authority)) }
        return UsernamePasswordAuthenticationToken(user.email, user.password, authorities)
    }

    private fun isValidLong(code: String): Boolean {
        try {
            code.toLong()
        } catch (e: NumberFormatException) {
            return false
        }
        return true
    }
}