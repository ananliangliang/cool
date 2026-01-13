package io.github.ananliangliang.cool

import io.github.ananliangliang.cool.config.*
import io.github.ananliangliang.cool.entity.TaskListTable
import io.github.ananliangliang.cool.entity.TaskTable
import io.github.ananliangliang.cool.entity.UserTable
import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.v1.core.ExperimentalDatabaseMigrationApi
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import org.jetbrains.exposed.v1.migration.jdbc.MigrationUtils
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

fun main(args: Array<String>) = EngineMain.main(args)

@OptIn(ExperimentalDatabaseMigrationApi::class, ExperimentalUuidApi::class)
fun Application.module() {
    configureDatabase()
    configureFrameworks()
    configureHttp()
    configureSecurity()
    configureSerialization()

    configureRouting() // 配置有顺序要求

    transaction {

        val isDev = System.getProperty("io.ktor.development").toBoolean()
        if (isDev)
            environment.log.trace("Dev environment")
            MigrationUtils.generateMigrationScript(
                TaskTable, TaskListTable, UserTable,
                scriptDirectory = "server/src/main/resources/db/migration",
                scriptName = Uuid.random().toString(),
            )
    }
//    monitor.subscribe(ApplicationStopping)
}