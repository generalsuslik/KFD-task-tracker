package kfd.tasktracker.database.repository

import kfd.tasktracker.database.entity.Task
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskDao : CrudRepository<Task, Long> {
}