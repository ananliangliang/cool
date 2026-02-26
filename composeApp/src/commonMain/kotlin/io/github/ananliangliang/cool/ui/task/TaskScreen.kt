package io.github.ananliangliang.cool.ui.task

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import cool.composeapp.generated.resources.Res
import cool.composeapp.generated.resources.task
import io.github.ananliangliang.cool.ui.component.TaskCompleteCheckBox
import io.github.ananliangliang.cool.ui.component.TaskListItem
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(onBack: () -> Unit = {}, toDetail: (Long) -> Unit = {}, viewModel: TaskViewModel = koinViewModel()) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(viewModel.uiState.showModal) {
        if (viewModel.uiState.showModal) {
            focusRequester.requestFocus()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                { Text(stringResource(Res.string.task)) },
                navigationIcon = {
                    IconButton(onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                })
        }) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            // 待办事项列表
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.uiState.tasks, { it.id!! }) { task ->
                    TaskListItem(
                        task = task,
                        onCompleted = { viewModel.handleTaskToggle(task) },
                        onImportant = { viewModel.handleTaskImportant(task) },
                        onDelete = { viewModel.deleteTask(task.id!!) },
                        onClick = { toDetail(task.id!!) },
                        modifier = Modifier.animateItem(),
                    )
                }
            }

            // 浮动按钮
            FloatingActionButton(
                onClick = viewModel::showModal,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "添加")
            }

            // 底部输入框
            if (viewModel.uiState.showModal) {
                ModalBottomSheet(
                    onDismissRequest = viewModel::handleModalDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    dragHandle = null
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = viewModel.uiState.titleOfNewTask,
                            onValueChange = viewModel::updateTitleOfNewTask,
                            modifier = Modifier.weight(1f).focusRequester(focusRequester),
                            prefix = {
                                TaskCompleteCheckBox(
                                    viewModel.uiState.isCompletedOfNewTask,
                                    viewModel::updateIsCompletedOfNewTask
                                )
                            },
                            placeholder = { Text("输入待办事项") },
                            singleLine = true,
                            suffix = {
                                IconButton(
                                    viewModel::handleTaskAddition,
                                    enabled = viewModel.uiState.titleOfNewTask.isNotBlank(),
                                ) {
                                    Icon(Icons.Default.ArrowUpward, "添加")
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}


