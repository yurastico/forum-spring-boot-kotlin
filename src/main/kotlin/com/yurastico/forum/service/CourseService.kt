package com.yurastico.forum.service

import com.yurastico.forum.model.Course
import com.yurastico.forum.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(private val courseRepository: CourseRepository) {


    fun findById(id: Long): Course {
        return courseRepository.getOne(id)
    }
}
