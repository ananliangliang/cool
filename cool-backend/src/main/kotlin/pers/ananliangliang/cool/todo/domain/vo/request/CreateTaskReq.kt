package pers.ananliangliang.cool.todo.domain.vo.request

import pers.ananliangliang.cool.todo.domain.Task

data class CreateTaskReq(
    val name: String,
    val note: String?,
) {
    fun toTask() = Task(name, note)
}
