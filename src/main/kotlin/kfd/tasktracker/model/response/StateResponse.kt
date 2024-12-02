package kfd.tasktracker.model.response

import java.time.LocalDateTime

data class StateResponse(
    val id: Long,
    val createdAt: LocalDateTime,
    val name: String,
)