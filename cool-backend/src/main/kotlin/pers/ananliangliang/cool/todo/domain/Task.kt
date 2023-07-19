package pers.ananliangliang.cool.todo.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import pers.ananliangliang.cool.common.BaseEntity

@Entity(name = "todo_task")
class Task(
    var name: String?,
    var note: String?,
    @Column(insertable = false) var isDone: Boolean?,
) : BaseEntity() {
    constructor(name:String, note: String?) : this(name, note, false)
}