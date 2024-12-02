package kfd.tasktracker.model.response

import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val createdAt: LocalDateTime,
    val name: String,
)
