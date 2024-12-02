package kfd.tasktracker.service

import kfd.tasktracker.database.entity.State
import kfd.tasktracker.model.request.StateRequest
import kfd.tasktracker.model.response.StateResponse

interface StateService {
    fun getById(id: Long) : State
    fun getAll() : List<StateResponse>
    fun create(request: StateRequest) : StateResponse
    fun delete(id: Long)
}