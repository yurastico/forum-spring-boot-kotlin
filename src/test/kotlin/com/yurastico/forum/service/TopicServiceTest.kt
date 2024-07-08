package com.yurastico.forum.service
import com.yurastico.forum.dto.TopicView
import com.yurastico.forum.mapper.TopicFormMapper
import com.yurastico.forum.mapper.TopicViewMapper
import com.yurastico.forum.model.Topic
import com.yurastico.forum.repository.TopicRepository
import jakarta.annotation.security.RunAs
import jakarta.inject.Inject
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import kotlin.test.assertEquals


class TopicServiceTest {

    @Mock
    private lateinit var topicRepository: TopicRepository
    @Mock
    private lateinit var topicViewMapper: TopicViewMapper
    @Mock
    private lateinit var topicFormMapper: TopicFormMapper
    @Mock
    private lateinit var pagination: Pageable

    @InjectMocks
    private lateinit var topicService: TopicService

    @BeforeEach
    fun run(){
        Mockito.`when`(topicRepository.findById(any()))
            .then {
                PageImpl(listOf(Topic(any(), any(), any(), any(), any(), any())))
            }

    }

    @Test
    fun `should list topics by course name`(){
        Mockito.`when`(topicViewMapper.map(any()))
            .then { listOf(TopicView(any(), any(), any(), any(), any(), any())) }


        topicService.list("kotlin advanced",pagination)

        verify(topicRepository.findById(any()),times(1))
        verify(topicViewMapper.map(any()),times(1))

    }

}