package pers.ananliangliang.todo.service

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentTimestampWithTimeZone
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.update
import pers.ananliangliang.todo.dto.Task
import pers.ananliangliang.todo.entity.TaskEntity
import pers.ananliangliang.todo.entity.TaskTable


class TaskService {


    suspend fun selectAll() = newSuspendedTransaction(Dispatchers.IO) {
        TaskEntity.all().map { it.toDto() }
    }

    suspend fun selectById(id: Long): Task? = newSuspendedTransaction(Dispatchers.IO) {
        TaskEntity.findById(id)?.toDto()
    }

    suspend fun create(task: Task): Long = newSuspendedTransaction(Dispatchers.IO) {
        TaskTable.insertAndGetId {
            it[name] = requireNotNull(task.name)
            it[note] = task.note
        }.value
    }

    suspend fun delete(id: Long) = newSuspendedTransaction(Dispatchers.IO) {
        TaskTable.deleteWhere { TaskTable.id eq id }
    }

    suspend fun update(id: Long, task: Task) = newSuspendedTransaction {
        TaskTable.update({ TaskTable.id eq id }) {
            it[name] = requireNotNull(task.name)
            it[note] = task.note
            it[isCompleted] = requireNotNull(task.isCompleted)
            it[isImportant] = requireNotNull(task.isImportant)
        }
    }

    suspend fun updatePartially(id: Long, task: Task) = newSuspendedTransaction {
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