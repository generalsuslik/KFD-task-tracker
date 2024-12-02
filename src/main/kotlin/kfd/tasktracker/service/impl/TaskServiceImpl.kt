package kfd.tasktracker.service.impl

import kfd.tasktracker.database.entity.Task
import kfd.tasktracker.database.repository.TaskDao
import kfd.tasktracker.model.request.TaskRequest
import kfd.tasktracker.model.response.TaskResponse
import kfd.tasktracker.service.StateService
import kfd.tasktracker.service.TaskService
import kfd.tasktracker.service.UserService
import kfd.tasktracker.util.TaskMapper
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl(
    val dao: TaskDao,
    val mapper: TaskMapper,
    val stateService: StateService,
    val userService: UserService,
) : TaskService {
    override fun getAll(): List<TaskResponse> =
        dao.findAll().map {
            mapper.entityToResponse(it)
        }

    override fun getById(id: Long): TaskResponse =
        mapper.entityToResponse(dao.findById(id).orElseThrow { throw RuntimeException("") })

    override fun update(id: Long, request: TaskRequest): TaskResponse {
        val entity = dao.findById(id).orElseThrow { throw RuntimeException("") }
            .apply {
                title = request.title
                description = request.description
                state = stateService.getById(request.stateId)
                users = request.userIds.map { userService.getById(it) }
            }
        return mapper.entityToResponse(dao.save(entity))
    }

    override fun create(request: TaskRequest): TaskResponse {
        val entity = Task(
            title = request.title,
            description = request.description
        ).apply {
            state = stateService.getById(request.stateId)
            users = request.userIds.map { userService.getById(it) }
        }
        return mapper.entityToResponse(dao.save(entity))
    }

    override fun delete(id: Long) {
        val entity = dao.findById(id).orElseThrow { throw RuntimeException("") }
        dao.delete(entity)
    }
}