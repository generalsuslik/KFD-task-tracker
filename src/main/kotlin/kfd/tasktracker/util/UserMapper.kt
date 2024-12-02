package kfd.tasktracker.util

import kfd.tasktracker.database.entity.User
import kfd.tasktracker.model.response.UserResponse
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun entityToResponse(entity: User) : UserResponse =
        UserResponse(
            id = entity.id,
            createdAt = entity.createdAt,
            name = entity.name,
        )
}