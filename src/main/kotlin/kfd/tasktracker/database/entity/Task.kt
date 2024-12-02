package kfd.tasktracker.database.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.Lob
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "task")
class Task(
    @Column(nullable = false)
    var title: String,
    @Column(nullable = false)
    @Lob
    var description: String,
) : AbstractEntity() {
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    var state: State? = null

    @ManyToMany(targetEntity = User::class)
    @JoinTable(
        name = "task_to_user",
        joinColumns = [JoinColumn(name = "task_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    var users: List<User> = listOf()
}