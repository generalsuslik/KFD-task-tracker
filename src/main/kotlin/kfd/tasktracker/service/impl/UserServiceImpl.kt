package kfd.tasktracker.service.impl

import kfd.tasktracker.database.entity.User
import kfd.tasktracker.database.repository.UserDao
import kfd.tasktracker.model.request.UserRequest
import kfd.tasktracker.model.response.DeletedResponse
import kfd.tasktracker.model.response.TaskResponse
import kfd.tasktracker.model.response.UserResponse
import kfd.tasktracker.service.UserService
import kfd.tasktracker.util.TaskMapper
import kfd.tasktracker.util.UserMapper
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val dao: UserDao,
    val mapper: UserMapper,
    val taskMapper: TaskMapper,
) : UserService {
    override fun getById(id: Long): User =
        dao.findById(id).orElseThrow { throw RuntimeException("") }

    override fun getAll(): List<UserResponse> =
        dao.findAll().map {
            mapper.entityToResponse(it)
        }

    override fun getTasks(id: Long): List<TaskResponse> {
        val entity = getById(id)
        return entity.tasks.map {
            taskMapper.entityToResponse(it)
        }
    }

    override fun update(id: Long, request: UserRequest): UserResponse {
        val entity = getById(id)
        entity.apply {
            name = request.name
        }
        return mapper.entityToResponse(dao.save(entity))
    }

    override fun create(request: UserRequest): UserResponse {
        val entity = User(
            name = request.name
        )
        return mapper.entityToResponse(dao.save(entity))
    }

    override fun delete(id: Long) : DeletedResponse {
        val entity = getById(id)
        dao.delete(entity)
        return DeletedResponse()
    }

}