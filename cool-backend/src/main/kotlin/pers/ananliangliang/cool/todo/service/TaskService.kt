package pers.ananliangliang.cool.todo.service

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import pers.ananliangliang.cool.common.SecurityUtils
import pers.ananliangliang.cool.todo.domain.vo.request.CreateTaskReq
import pers.ananliangliang.cool.todo.repository.TaskRepository

@Service
class TaskService(
    private val repository: TaskRepository,
) {
    fun createTask(req: CreateTaskReq) {
        repository.save(req.toTask())
    }


    fun listTask() = repository.getByIsDoneFalse()
}