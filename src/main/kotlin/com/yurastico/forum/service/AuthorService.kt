package com.yurastico.forum.service

import com.yurastico.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(var users: List<User>) {

    init {
        val user = User(
                id = 1,
                name = "yurastico",
                email = "yurastico@yurastico.com"
        )
        users = Arrays.asList(user)
    }

    fun findById(id: Long): User {
        return users.stream().filter {
            u -> u.id == id
        }.findFirst().get()
    }

}
