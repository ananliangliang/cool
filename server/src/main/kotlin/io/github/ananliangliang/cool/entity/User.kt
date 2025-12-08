package pers.ananliangliang.todo.entity

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

object UserTable : LongIdTable("user") {
    val name = text("name")
    val username = text("username")
    val password = text("password")
}

class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object Companion : LongEntityClass<UserEntity>(UserTable)

    var name by UserTable.name
    var username by UserTable.username
    var password by UserTable.password
}

fun main() {
    println(UserTable.tableName)
    println(TaskTable.tableName)
}

