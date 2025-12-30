package io.github.ananliangliang.cool.ui.task.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.ananliangliang.cool.data.remote.ApiService
import io.github.ananliangliang.cool.dto.todo.Task
import kotlinx.coroutines.launch
import io.github.ananliangliang.cool.util.toHumanReadableDate
import kotlin.time.ExperimentalTime

class TaskDetailViewModel(
    private val id: Long,
    private val apiService: ApiService
) : ViewModel() {

    @OptIn(ExperimentalTime::class)
    var task by mutableStateOf(Task())
        private set
    
    var formattedCreatedAt by mutableStateOf<String>("")
        private set

    init {
        loadTask()
    }

    @OptIn(ExperimentalTime::class)
    fun loadTask() {
        viewModelScope.launch {
            task = apiService.getTask(id)
            task.createdAt?.let { instant ->
                formattedCreatedAt = instant.toHumanReadableDate()
            }
        }
    }

    @OptIn(ExperimentalTime::class)
    fun updateName(name: String) {
        task = task.copy(name = name)
    }
    @OptIn(ExperimentalTime::class)
    fun updateNote(note: String) {
        task = task.copy(note = note)
    }
    @OptIn(ExperimentalTime::class)
    fun toggleIsCompleted() {
        task = task.copy(isCompleted = task.isCompleted?.not())
    }
    @OptIn(ExperimentalTime::class)
    fun toggleIsImportant() {
        task = task.copy(isImportant = task.isImportant?.not())
    }
}