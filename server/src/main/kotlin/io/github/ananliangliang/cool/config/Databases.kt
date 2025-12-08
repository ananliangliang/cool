package pers.ananliangliang.todo.config

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase() {
    environment.config.let {
        Database.connect(
            url = it.property("postgres.url").getString(),
            user = it.property("postgres.user").getString(),
            password = it.property("postgres.password").getString(),
            setupConnection = { connection -> connection.schema = "todo" }
        )
    }
}