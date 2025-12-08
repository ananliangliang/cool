package pers.ananliangliang.todo.entity

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

object TaskListTable : LongIdTable("task_list") {
    val name = text("name")
    val createdById = long("created_by_id")
}
class TaskListEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<TaskListEntity>(TaskListTable)

    var name by TaskListTable.name
    var createdById by TaskListTable.createdById

}

