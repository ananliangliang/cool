package io.github.ananliangliang.cool

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    routing {
        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }
    }
}
fun Application.module() {
    configureDatabase()
    configureFrameworks()
    configureHttp()
    configureSecurity()
    configureSerialization()

    configureRouting() // 配置有顺序要求
}