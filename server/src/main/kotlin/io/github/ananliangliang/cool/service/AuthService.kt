package io.github.ananliangliang.cool.service

import io.github.ananliangliang.cool.dto.auth.LoginReq
import io.ktor.server.plugins.*
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.springframework.security.crypto.password.PasswordEncoder
import io.github.ananliangliang.cool.entity.UserEntity
import io.github.ananliangliang.cool.entity.UserTable

class AuthService(
    private val passwordEncoder: PasswordEncoder,
) {

    suspend fun login(req: LoginReq): UserEntity = suspendTransaction {
        val userEntity = UserEntity.find { UserTable.username eq req.username }
            .firstOrNull() ?: throw NotFoundException()

        passwordEncoder.matches(req.password, userEntity.password)
        userEntity
    }
}