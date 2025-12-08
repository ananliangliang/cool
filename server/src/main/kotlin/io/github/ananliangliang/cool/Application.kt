package io.github.ananliangliang.cool

import io.github.ananliangliang.cool.config.*
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureDatabase()
    configureFrameworks()
    configureHttp()
    configureSecurity()
    configureSerialization()

    configureRouting() // 配置有顺序要求
}