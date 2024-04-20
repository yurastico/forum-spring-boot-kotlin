package com.yurastico.forum.service

import com.yurastico.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var courses: List<Course>) {
    init {
        val course = Course(
                id = 1,
                name = "kotlin",
                category = "idk"
        )
        courses = Arrays.asList(course)
    }

    fun findById(id: Long): Course {
        return courses.stream().filter {
            c -> c.id == id
        }.findFirst().get()
    }
}
