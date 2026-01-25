package io.github.ananliangliang.cool.config

import io.ktor.server.application.*
import org.jetbrains.exposed.v1.jdbc.Database

fun Application.configureDatabase() {
    environment.config.let {
        Database.connect(
            url = it.property("h2.url").getString(),
            user = it.property("h2.user").getString(),
            password = it.property("h2.password").getString(),
        )
    }
}