package com.yurastico.forum.dto

import com.yurastico.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicView(
        val id: Long?,
        val title: String,
        val message: String,
        val status: TopicStatus,
        val createdAt: LocalDateTime
)