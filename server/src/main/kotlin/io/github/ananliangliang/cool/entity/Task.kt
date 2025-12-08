package pers.ananliangliang.todo.entity

import kotlinx.datetime.toKotlinInstant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentDate
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentTimestamp
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentTimestampWithTimeZone
import org.jetbrains.exposed.sql.kotlin.datetime.timestampWithTimeZone
import pers.ananliangliang.todo.dto.Task

object TaskTable : LongIdTable() {
    val name = text("name")
    val note = text("note").nullable()
    val isCompleted = bool("is_completed")
    val completedAt = timestampWithTimeZone("completed_at").nullable()
    val isImportant = bool("is_important")
    val importantAt = timestampWithTimeZone("important_at").nullable()
    val createdAt = timestampWithTimeZone("created_at").defaultExpression(CurrentTimestampWithTimeZone)
    val createdById = long("created_by_id").nullable()
}
class TaskEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<TaskEntity>(TaskTable)

    var name by TaskTable.name
    var note by TaskTable.note
    var isCompleted by TaskTable.isCompleted
    var isImportant by TaskTable.isImportant
    var createdAt by TaskTable.createdAt
    var completedAt by TaskTable.completedAt
    var importantAt by TaskTable.importantAt
    var createdById by TaskTable.createdById

    fun toDto() = Task(
        id = id.value,
        name = name,
        note = note,
        isCompleted = isCompleted,
        isImportant = isImportant,
        createdAt = createdAt.toInstant().toKotlinInstant(),
        createdById = createdById,
    )
}

