package kfd.tasktracker.controller

import kfd.tasktracker.model.request.TaskRequest
import kfd.tasktracker.service.TaskService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(
    val taskService: TaskService,
) {
    @GetMapping
    fun getAll() = taskService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long) = taskService.getById(id)

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody request: TaskRequest) = taskService.update(id, request)

    @PostMapping
    fun create(@RequestBody request: TaskRequest) = taskService.create(request)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long,) = taskService.delete(id)
}