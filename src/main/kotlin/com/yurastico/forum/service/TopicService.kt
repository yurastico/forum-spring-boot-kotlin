package com.yurastico.forum.service

import com.yurastico.forum.dto.NewTopicDto
import com.yurastico.forum.model.Course
import com.yurastico.forum.model.Topic
import com.yurastico.forum.model.User
import org.springframework.stereotype.Service
import java.util.*


@Service
class TopicService(private var topics: List<Topic>,
        private val courseService: CourseService) {
    init {
        val topic = Topic(
                id = 1,
                title = "Duvida Kotlin",
                message = "Variaveis no Kotlin",
                course = Course (
                        id = 1,
                        name = "Kotlin",
                        category = "Programacao"
                ),
                author = User(
                        id = 1,
                        name = "Ana da Silva",
                        email = "ana@email.com"
                )
        )
        topics = Arrays.asList(topic,topic,topic)
    }
    fun list(): List<Topic> {
        return topics
    }

    fun findById(id: Long): Topic {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun createTopic(dto: NewTopicDto) {

        topics.plus(Topic(
                title = dto.title,
                message = dto.message,
                course =
        ))
    }


}