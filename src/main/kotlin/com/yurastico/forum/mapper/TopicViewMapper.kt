package com.yurastico.forum.mapper

import com.yurastico.forum.dto.TopicView
import com.yurastico.forum.model.Topic
import org.springframework.stereotype.Component


@Component
class TopicViewMapper: Mapper<Topic,TopicView> {
    override fun map(t: Topic): TopicView {

        return TopicView(id = t.id,
                title = t.title,
                message = t.message,
                createdAt = t.createdAt,
                status = t.status)
    }
}