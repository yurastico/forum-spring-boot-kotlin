package com.yurastico.forum.mapper

import com.yurastico.forum.dto.NewTopicForm
import com.yurastico.forum.model.Topic
import com.yurastico.forum.service.CourseService
import com.yurastico.forum.service.UserService

import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
        private val courseService: CourseService,
        private val userService: UserService
): Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        return Topic(

                title = t.title,
                message = t.message,
                course = courseService.findById(t.idCourse),
                author = userService.findById(t.idAuthor),
                modifiedAt = t.modifiedAt
        )
    }

}
