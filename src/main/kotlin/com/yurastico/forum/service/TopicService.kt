package com.yurastico.forum.service

import com.yurastico.forum.dto.NewTopicForm
import com.yurastico.forum.dto.TopicView
import com.yurastico.forum.dto.UpdateTopicForm
import com.yurastico.forum.exception.NotFoundException
import com.yurastico.forum.mapper.TopicFormMapper
import com.yurastico.forum.mapper.TopicViewMapper
import com.yurastico.forum.model.Course
import com.yurastico.forum.model.Topic
import com.yurastico.forum.model.User
import com.yurastico.forum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors


@Service
class TopicService(private val topicRepository: TopicRepository,
        private val topicViewMapper: TopicViewMapper,
        private val topicFormMapper: TopicFormMapper,
        private val notFoundMessage: String = "Topic not found") {

    fun list(courseName: String?,
             pagination: Pageable
             ): Page<TopicView> {
        val topics = if (courseName == null) {
            topicRepository.findAll(pagination)
        } else {
            topicRepository.findByCourseName(courseName,pagination)
        }
        return topics.map {
            t -> topicViewMapper.map(t)
        }
    }

    fun findById(id: Long): TopicView {
        val topic = topicRepository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
        return topicViewMapper.map(topic)
    }

    fun createTopic(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topicRepository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun updateTopic(form: UpdateTopicForm): TopicView {
        val topic = topicRepository.findById(form.id).orElseThrow{NotFoundException(notFoundMessage)}

        topic.title = form.title
        topic.message = form.message

        return topicViewMapper.map(topic)
    }

    fun deleteTopic(id: Long) {
        topicRepository.deleteById(id)
    }
}