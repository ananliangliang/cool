package pers.ananliangliang.todo.service

import io.github.ananliangliang.cool.dto.auth.LoginReq
import io.ktor.server.plugins.*
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.springframework.security.crypto.password.PasswordEncoder
import pers.ananliangliang.todo.entity.UserEntity
import pers.ananliangliang.todo.entity.UserTable

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