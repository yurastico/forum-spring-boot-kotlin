package com.yurastico.forum.service

import com.yurastico.forum.model.User
import com.yurastico.forum.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {



    fun findById(id: Long): User {
        return userRepository.getOne(id)
    }

}
