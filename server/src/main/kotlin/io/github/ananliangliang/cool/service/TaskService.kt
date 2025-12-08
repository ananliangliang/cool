package pers.ananliangliang.todo.service

import io.github.ananliangliang.cool.dto.todo.Task
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.datetime.CurrentTimestampWithTimeZone
import org.jetbrains.exposed.v1.jdbc.deleteWhere
import org.jetbrains.exposed.v1.jdbc.insertAndGetId
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.jetbrains.exposed.v1.jdbc.update
import pers.ananliangliang.todo.entity.TaskEntity
import pers.ananliangliang.todo.entity.TaskTable


class TaskService {


    suspend fun selectAll() = suspendTransaction {
        TaskEntity.all().map { it.toDto() }
    }

    suspend fun selectById(id: Long): Task? = suspendTransaction {
        TaskEntity.findById(id)?.toDto()
    }

    suspend fun create(task: Task): Long = suspendTransaction {
        TaskTable.insertAndGetId {
            it[name] = requireNotNull(task.name)
            it[note] = task.note
        }.value
    }

    suspend fun delete(id: Long) = suspendTransaction {
        TaskTable.deleteWhere { TaskTable.id eq id }
    }

    suspend fun update(id: Long, task: Task) = suspendTransaction {
        TaskTable.update({ TaskTable.id eq id }) {
            it[name] = requireNotNull(task.name)
            it[note] = task.note
            it[isCompleted] = requireNotNull(task.isCompleted)
            it[isImportant] = requireNotNull(task.isImportant)
        }
    }

    suspend fun updatePartially(id: Long, task: Task) = suspendTransaction {
        TaskTable.update({ TaskTable.id eq id }) {
            if (task.name != null) it[name] = task.name!!
            if (task.note != null) it[note] = task.note
            if (task.isCompleted != null) it[isCompleted] = task.isCompleted!!
            if (task.isCompleted == true) it[completedAt] = CurrentTimestampWithTimeZone
            else if (task.isCompleted == false) it[completedAt] = null

            if (task.isImportant != null) it[isImportant] = task.isImportant!!
            if (task.isImportant == true) it[importantAt] = CurrentTimestampWithTimeZone
        }
    }
}