package com.yurastico.forum.service

import com.yurastico.forum.model.User
import com.yurastico.forum.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository): UserDetailsService {



    fun findById(id: Long): User {
        return userRepository.getOne(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(user)
    }

}
