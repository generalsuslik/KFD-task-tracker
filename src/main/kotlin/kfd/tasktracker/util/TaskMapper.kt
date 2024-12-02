package kfd.tasktracker.util

import kfd.tasktracker.database.entity.Task
import kfd.tasktracker.model.response.TaskResponse
import org.springframework.stereotype.Component

@Component
class TaskMapper {
    fun entityToResponse(entity: Task) : TaskResponse =
        TaskResponse(
            id = entity.id,
            createdAt = entity.createdAt,
            title = entity.title,
            description = entity.description,
            state = entity.state!!.name,
            users = entity.users.map {user -> user.name}
        )
}