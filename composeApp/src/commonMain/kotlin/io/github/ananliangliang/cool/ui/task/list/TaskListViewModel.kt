package io.github.ananliangliang.cool.ui.task.list

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import io.github.ananliangliang.cool.dto.todo.TaskList

class TaskListViewModel() : ViewModel() {

    val taskListList = mutableStateListOf(
        TaskList(id = 1, name = "Work", createdById = 1),
        TaskList(id = 2, name = "Personal", createdById = 1),
        TaskList(id = 3, name = "Shopping", createdById = 1),
    )

}