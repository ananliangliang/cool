package io.github.ananliangliang.cool.dto.todo

import kotlinx.serialization.Serializable
import kotlin.time.ExperimentalTime
import kotlin.time.Instant


@OptIn(ExperimentalTime::class)
@Serializable
data class Task(
    val id: Long? = null,
    val name: String? = null,
    val note: String? = null,
    val isCompleted: Boolean? = null,
    val isImportant: Boolean? = null,
    val createdAt: Instant? = null,
    val createdById: Long? = null,
)