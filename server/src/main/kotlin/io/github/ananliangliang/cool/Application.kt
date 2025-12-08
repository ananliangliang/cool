package io.github.ananliangliang.cool

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import pers.ananliangliang.todo.config.configureDatabase
import pers.ananliangliang.todo.config.configureFrameworks
import pers.ananliangliang.todo.config.configureHttp
import pers.ananliangliang.todo.config.configureRouting
import pers.ananliangliang.todo.config.configureSecurity
import pers.ananliangliang.todo.config.configureSerialization

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureDatabase()
    configureFrameworks()
    configureHttp()
    configureSecurity()
    configureSerialization()

    configureRouting() // 配置有顺序要求
}