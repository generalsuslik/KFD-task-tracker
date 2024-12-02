package kfd.tasktracker.database.repository

import kfd.tasktracker.database.entity.State
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StateDao : CrudRepository<State, Long> {
}