package kfd.tasktracker.service

import kfd.tasktracker.database.entity.User
import kfd.tasktracker.model.request.UserRequest
import kfd.tasktracker.model.response.TaskResponse
import kfd.tasktracker.model.response.UserResponse

interface UserService {
    fun getById(id: Long) : User
    fun getAll() : List<UserResponse>
    fun getTasks(id: Long) : List<TaskResponse>
    fun update(id: Long, request: UserRequest) : UserResponse
    fun create(request: UserRequest) : UserResponse
    fun delete(id: Long)
}