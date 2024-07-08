package com.yurastico.forum.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Topic(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var title: String,
        var message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val course: Course,
        @ManyToOne
        val author: User,
        @Enumerated(value = EnumType.STRING)
        val status: TopicStatus = TopicStatus.NOT_ANSWERED,
        @OneToMany(mappedBy = "topic")
        val answers: List<TopicResponse> = ArrayList(),
        var modifiedAt: LocalDate? = null

)