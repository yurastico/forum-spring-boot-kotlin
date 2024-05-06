package com.yurastico.forum.repository

import com.yurastico.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course,Long> {
}