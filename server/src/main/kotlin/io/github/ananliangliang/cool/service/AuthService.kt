package pers.ananliangliang.todo.service

import io.ktor.server.plugins.NotFoundException
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.springframework.security.crypto.password.PasswordEncoder
import pers.ananliangliang.todo.dto.auth.LoginReq
import pers.ananliangliang.todo.entity.UserEntity
import pers.ananliangliang.todo.entity.UserTable

class AuthService(
    private val passwordEncoder: PasswordEncoder,
) {

    suspend fun login(req: LoginReq): UserEntity = newSuspendedTransaction(Dispatchers.IO) {
        val userEntity = UserEntity.find { UserTable.username eq req.username }
            .firstOrNull() ?: throw NotFoundException()

        passwordEncoder.matches(req.password, userEntity.password)
        userEntity
    }
}