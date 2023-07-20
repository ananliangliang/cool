package pers.ananliangliang.cool.todo.domain.vo.request

import jakarta.validation.constraints.Size
import pers.ananliangliang.cool.todo.domain.Task

data class CreateTaskReq(
    @Size(max = 255) val name: String,
    val note: String?,
) {
    fun toTask() = Task(name, note)
}
