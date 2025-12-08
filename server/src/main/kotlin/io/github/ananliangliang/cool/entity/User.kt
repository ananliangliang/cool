package io.github.ananliangliang.cool.entity

import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.LongIdTable
import org.jetbrains.exposed.v1.dao.LongEntity
import org.jetbrains.exposed.v1.dao.LongEntityClass

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

