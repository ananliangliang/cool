package io.github.ananliangliang.cool.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginReq(
    val username: String,
    val password: String,
)
