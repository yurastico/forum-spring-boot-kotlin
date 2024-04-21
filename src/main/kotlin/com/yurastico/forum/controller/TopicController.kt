package com.yurastico.forum.controller

import com.yurastico.forum.dto.NewTopicForm
import com.yurastico.forum.dto.TopicView
import com.yurastico.forum.model.Topic
import com.yurastico.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topic")
class TopicController(private val service: TopicService) {
    @GetMapping
    fun list(): List<TopicView> {
        return service.list()

    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return service.findById(id)
    }
    @PostMapping
    fun createTopic(@RequestBody @Valid topic: NewTopicForm) {
        service.createTopic(topic)
    }

}