package kfd.tasktracker.database.repository

import kfd.tasktracker.database.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao : CrudRepository<User, Long> {
}