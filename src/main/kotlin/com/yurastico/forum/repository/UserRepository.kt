package com.yurastico.forum.repository

import com.yurastico.forum.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User,Long> {
}