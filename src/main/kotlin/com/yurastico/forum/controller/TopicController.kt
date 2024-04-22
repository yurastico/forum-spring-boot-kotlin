package com.yurastico.forum.controller

import com.yurastico.forum.dto.NewTopicForm
import com.yurastico.forum.dto.TopicView
import com.yurastico.forum.dto.UpdateTopicForm
import com.yurastico.forum.model.Topic
import com.yurastico.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

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
    fun createTopic(@RequestBody @Valid topic: NewTopicForm,
                    uriBuilder: UriComponentsBuilder): ResponseEntity<TopicView> {
        val topicView = service.createTopic(topic)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }
    @PutMapping
    fun updateTopic(@RequestBody @Valid topic: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.updateTopic(topic)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }

}