package com.yurastico.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class NewTopicForm(
        @field:NotEmpty @Size(min = 5, max = 100, message = "Cant be empty")
        val title: String,
        @field:NotEmpty
        val message: String,
        @field:NotNull
        val idCourse: Long,
        @field:NotNull
        val idAuthor: Long,
        val modifiedAt: LocalDate?

)
