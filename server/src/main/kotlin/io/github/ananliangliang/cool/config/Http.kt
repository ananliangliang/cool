package io.github.ananliangliang.cool.config

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Application.configureHttp() {
    install(CORS) {

        anyMethod()
        anyHost()
        allowHeader(HttpHeaders.ContentType)
    }
    routing {
        swaggerUI(path = "swagger")
    }
}