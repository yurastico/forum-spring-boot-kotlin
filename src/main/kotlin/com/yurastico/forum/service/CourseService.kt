package com.yurastico.forum.service

import com.yurastico.forum.dto.CourseView
import com.yurastico.forum.mapper.CourseViewMapper
import com.yurastico.forum.model.Course
import com.yurastico.forum.repository.CourseRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(private val courseRepository: CourseRepository,
    private val courseViewMappar: CourseViewMapper
) {


    fun findById(id: Long): Course {
        return courseRepository.getOne(id)
    }

    fun list(pagination: Pageable): Page<CourseView> {
        return courseRepository.findAll(pagination).map { c -> courseViewMappar.map(c) }
    }
}
