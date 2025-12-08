package io.github.ananliangliang.cool.dto.todo

import kotlinx.serialization.Serializable

@Serializable
data class TaskList(
    val id: Long,
    val name: String,
    val createdById: Long,
)