package com.yurastico.forum.model

import java.time.LocalDate
import java.time.LocalDateTime

data class Topic(
        var id: Long? = null,
        val title: String,
        var message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val course: Course,
        val author: User,
        val status: TopicStatus = TopicStatus.NOT_ANSWERED,
        val answers: List<TopicResponse> = ArrayList()

)