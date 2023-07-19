package pers.ananliangliang.cool.todo.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pers.ananliangliang.cool.todo.domain.vo.request.CreateTaskReq
import pers.ananliangliang.cool.todo.service.TaskService

@RestController
@RequestMapping("/todo")
class TaskController(
    private val service: TaskService,
) {

    @PostMapping("/tasks")
    fun createTask(@RequestBody req: CreateTaskReq) = service.createTask(req)


    @PreAuthorize("isAnonymous()")
    @GetMapping("/tasks")
    fun listTask() = service.listTask()
}