package com.yurastico.forum.controller

import com.yurastico.forum.dto.CourseView
import com.yurastico.forum.model.Course
import com.yurastico.forum.service.CourseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/course")
class CourseController(
    private val service: CourseService
) {
    @GetMapping
    fun listCourses(pagination: Pageable): Page<CourseView> {
        return service.list(pagination = pagination)
    }
}