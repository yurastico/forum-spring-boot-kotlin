package com.yurastico.forum.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

data class TopicResponse(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val author: User,
        @ManyToOne
        val topic: Topic,
        val solution: Boolean
)
