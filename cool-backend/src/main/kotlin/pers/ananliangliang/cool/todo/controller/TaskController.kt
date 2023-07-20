package pers.ananliangliang.cool.todo.controller

import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import pers.ananliangliang.cool.todo.domain.vo.request.CreateTaskReq
import pers.ananliangliang.cool.todo.service.TaskService

@Validated
@RestController
@RequestMapping("/todo")
class TaskController(
    private val service: TaskService,
) {

    @PostMapping("/tasks")
    fun createTask(@Valid @RequestBody req: CreateTaskReq) = service.createTask(req)

    @GetMapping("/tasks")
    fun listTask() = service.listTask()

    @DeleteMapping("/tasks/{id}")
    fun deleteTask(@PathVariable id: Long) = service.deleteTask(id)
}