package com.yurastico.forum.repository

import com.yurastico.forum.dto.TopicPerCategoryDto
import com.yurastico.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic,Long> {
    //fun findByCourseName(courseName: String,pagination: Pageable): Page<Topic>
    //@Query("SELECT new com.yurastico.forum.dto.TopicPerCategoryDto(course.category, count(t)) FROM Topic AS t INNER JOIN Course AS c ON t.course_id = c.id GROUP BY c.category")
    //fun info(): List<TopicPerCategoryDto>
}

