package io.github.ananliangliang.cool.config

import io.ktor.server.application.*
import org.jetbrains.exposed.v1.jdbc.Database

fun Application.configureDatabase() {
    environment.config.let {
        Database.connect(
            url = it.property("postgres.url").getString(),
            user = it.property("postgres.user").getString(),
            password = it.property("postgres.password").getString(),
            setupConnection = { connection -> connection.schema = "cool" }
        )
    }
}