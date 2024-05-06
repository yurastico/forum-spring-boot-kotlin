package com.yurastico.forum.repository

import com.yurastico.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic,Long> {

}