package com.yurastico.forum.controller

import com.yurastico.forum.dto.NewTopicDto
import com.yurastico.forum.model.Topic
import com.yurastico.forum.service.TopicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topic")
class TopicController(private val service: TopicService) {
    @GetMapping
    fun list(): List<Topic> {
        return service.list()

    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Topic {
        return service.findById(id)
    }
    @PostMapping
    fun createTopic(@RequestBody topic: NewTopicDto) {
        service.createTopic(topic)
    }

}