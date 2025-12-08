package io.github.ananliangliang.cool.ui.task

import io.github.ananliangliang.cool.dto.todo.Task


data class TaskUiState(
    val tasks: List<Task> = listOf(),
    val showModal: Boolean = false,
    val titleOfNewTask: String = "",
    val isCompletedOfNewTask: Boolean = false,
    val enabledOfTaskAddition: Boolean = false,
)