package io.github.ananliangliang.cool.config

import io.ktor.server.application.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import io.github.ananliangliang.cool.service.AuthService
import io.github.ananliangliang.cool.service.TaskService

fun Application.configureFrameworks() {
    install(Koin) {
        modules(module {
            singleOf(::TaskService)
            singleOf(::AuthService)
            single<PasswordEncoder> {
                @Suppress("DEPRECATION")
                DelegatingPasswordEncoder(
                    "noop",
                    mapOf(
                        "noop" to NoOpPasswordEncoder.getInstance(),
                        "bcrypt" to BCryptPasswordEncoder(),
                    )
                )
            }
        })
    }


}