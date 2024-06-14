package com.yurastico.forum.mapper

import com.yurastico.forum.dto.CourseView
import com.yurastico.forum.dto.TopicView
import com.yurastico.forum.model.Course
import com.yurastico.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class CourseViewMapper: Mapper<Course, CourseView> {
    override fun map(t: Course): CourseView {

        return CourseView(
            name = t.name,
            category = t.category
            )
    }
}