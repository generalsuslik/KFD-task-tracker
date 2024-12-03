package kfd.tasktracker.service

import kfd.tasktracker.model.request.TaskRequest
import kfd.tasktracker.model.response.DeletedResponse
import kfd.tasktracker.model.response.TaskResponse

interface TaskService {
    fun getAll() : List<TaskResponse>
    fun getById(id: Long) : TaskResponse
    fun update(id: Long, request: TaskRequest) : TaskResponse
    fun create(request: TaskRequest) : TaskResponse
    fun delete(id: Long): DeletedResponse
}