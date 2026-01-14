package io.github.ananliangliang.cool.data.remote

import io.github.ananliangliang.cool.dto.auth.LoginReq
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class AuthService(private val client: HttpClient) {
    suspend fun login(username: String) {
        client.post("auth/login") {
            contentType(ContentType.Application.Json)
            setBody(LoginReq(username))
        }
    }
}