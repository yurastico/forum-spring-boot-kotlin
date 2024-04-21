package com.yurastico.forum.service

import com.yurastico.forum.dto.NewTopicForm
import com.yurastico.forum.dto.TopicView
import com.yurastico.forum.mapper.TopicFormMapper
import com.yurastico.forum.mapper.TopicViewMapper
import com.yurastico.forum.model.Course
import com.yurastico.forum.model.Topic
import com.yurastico.forum.model.User
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors


@Service
class TopicService(private var topics: List<Topic>,
        private val topicViewMapper: TopicViewMapper,
        private val topicFormMapper: TopicFormMapper) {
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
    fun list(): List<TopicView> {
        return topics.stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun createTopic(form: NewTopicForm) {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics.plus(topic)
    }
}