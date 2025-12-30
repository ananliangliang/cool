package io.github.ananliangliang.cool.ui.task

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.ananliangliang.cool.data.remote.ApiService
import io.github.ananliangliang.cool.dto.todo.Task
import kotlinx.coroutines.launch
import kotlin.time.ExperimentalTime

class TaskViewModel(
    private val apiService: ApiService
) : ViewModel() {

    var uiState by mutableStateOf(TaskUiState())
        private set


    init {
        viewModelScope.launch {
            loadTasks()
        }
    }

    fun handleModalDismiss() {
        if (uiState.titleOfNewTask.isNotBlank()) handleTaskAddition()
        hideModal()
    }

    fun hideModal() {
        uiState = uiState.copy(showModal = false)
    }

    fun showModal() {
        uiState = uiState.copy(showModal = true, titleOfNewTask = "")
    }




    @OptIn(ExperimentalTime::class)
    fun handleTaskToggle(task: Task) {
        viewModelScope.launch {
            val patchTaskDto = Task(id = task.id, isCompleted = task.isCompleted?.not())
            apiService.patchTask(patchTaskDto)
            loadTasks() // Refresh the task list
        }
    }
    fun updateTitleOfNewTask(title: String) {
        uiState = uiState.copy(titleOfNewTask = title)
    }

    fun updateIsCompletedOfNewTask() {
        uiState = uiState.copy(isCompletedOfNewTask = !uiState.isCompletedOfNewTask)
    }


    suspend fun loadTasks() {
        uiState = uiState.copy(tasks = apiService.getTasks())
    }

    @OptIn(ExperimentalTime::class)
    fun handleTaskAddition() {
        viewModelScope.launch {
            val newTask = Task(
                id = null,
                name = uiState.titleOfNewTask,
                note = null,
                isCompleted = uiState.isCompletedOfNewTask,
                isImportant = false,
                createdAt = null
            )
            apiService.postTask(newTask)
            loadTasks()
            hideModal()
        }


    }

    fun deleteTask(id: Long)  = viewModelScope.launch {
        apiService.deleteTask(id)
        loadTasks() // Refresh the task list
    }

    @OptIn(ExperimentalTime::class)
    fun handleTaskImportant(task: Task) {
        viewModelScope.launch {
            val patchTaskDto = Task(id = task.id!!, isImportant = task.isImportant?.not())
            apiService.patchTask(patchTaskDto)
            loadTasks() // Refresh the task list
        }
    }
}