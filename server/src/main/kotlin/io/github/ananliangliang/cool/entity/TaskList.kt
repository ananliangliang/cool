package pers.ananliangliang.todo.entity

import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.LongIdTable
import org.jetbrains.exposed.v1.dao.LongEntity
import org.jetbrains.exposed.v1.dao.LongEntityClass

object TaskListTable : LongIdTable("task_list") {
    val name = text("name")
    val createdById = long("created_by_id")
}
class TaskListEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<TaskListEntity>(TaskListTable)

    var name by TaskListTable.name
    var createdById by TaskListTable.createdById

}

