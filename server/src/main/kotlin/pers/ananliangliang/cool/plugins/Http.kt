package pers.ananliangliang.cool.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureHTTP() {
    routing {
        val swaggerFile = "docs/openapi.yml"
        if (File(swaggerFile).exists()) swaggerUI(path = "swagger", swaggerFile = "docs/openapi.yml")
    }
}
