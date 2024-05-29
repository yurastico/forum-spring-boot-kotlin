package com.yurastico.forum.repository

import com.yurastico.forum.dto.TopicPerCategoryDto
import com.yurastico.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic,Long> {
    fun findByCourseName(courseName: String,pagination: Pageable): Page<Topic>
    @Query("select new com.yurastico.forum.dto.TopicPerCategory course.category, count(t)")
    fun info(): List<TopicPerCategoryDto>
}