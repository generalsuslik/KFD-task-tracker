package kfd.tasktracker.service.impl

import kfd.tasktracker.database.entity.State
import kfd.tasktracker.database.repository.StateDao
import kfd.tasktracker.exception.exception.AlreadyExistsException
import kfd.tasktracker.exception.exception.NotFoundException
import kfd.tasktracker.model.request.StateRequest
import kfd.tasktracker.model.response.DeletedResponse
import kfd.tasktracker.model.response.StateResponse
import kfd.tasktracker.service.StateService
import kfd.tasktracker.util.StateMapper
import org.springframework.stereotype.Service

@Service
class StateServiceImpl(
    val dao: StateDao,
    val mapper: StateMapper,
) : StateService {
    override fun getById(id: Long): State =
        dao.findById(id).orElseThrow {
            NotFoundException("Could not find state with id: $id")
        }

    override fun getAll(): List<StateResponse> =
        dao.findAll().map {
            mapper.entityToResponse(it)
        }

    override fun create(request: StateRequest): StateResponse {
        val states: MutableIterable<State> = dao.findAll()
        for (state in states) {
            if (state.name == request.name) {
                throw AlreadyExistsException("State with name ${request.name} already exists")
            }
        }
        val entity = State(
            name = request.name
        )
        return mapper.entityToResponse(dao.save(entity))
    }

    override fun delete(id: Long): DeletedResponse {
        val entity = getById(id)
        dao.delete(entity)
        return DeletedResponse()
    }

}