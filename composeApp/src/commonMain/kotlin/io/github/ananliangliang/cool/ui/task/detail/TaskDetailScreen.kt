package io.github.ananliangliang.cool.ui.task.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cool.composeapp.generated.resources.Res
import cool.composeapp.generated.resources.created_at
import cool.composeapp.generated.resources.task
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import io.github.ananliangliang.cool.ui.component.TaskCompleteCheckBox
import io.github.ananliangliang.cool.ui.component.TaskImportantCheckBox


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailScreen(
    taskId: Long, onBack: () -> Unit = {},
    modifier: Modifier = Modifier,
    viewModel: TaskDetailViewModel = koinViewModel { parametersOf(taskId) }
) {
    Scaffold(
        topBar = {
            TopAppBar(
                { Text(stringResource(Res.string.task)) },
                navigationIcon = {
                    IconButton(onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                })
        }
    ) { paddingValues ->
        Box(modifier.padding(paddingValues)) {
            Column {
                TextField(
                    value = viewModel.task.name ?: "",
                    onValueChange = viewModel::updateName,
                    modifier = Modifier.fillMaxWidth(),
                    prefix = {
                        TaskCompleteCheckBox(
                            viewModel.task.isCompleted == true,
                            viewModel::toggleIsCompleted
                        )
                    },
                    placeholder = { Text("输入待办事项") },
                    singleLine = true,
                    suffix = {
                        TaskImportantCheckBox(
                            viewModel.task.isImportant == true,
                            viewModel::toggleIsImportant,
                        )
                    })
                TextField(
                    value = viewModel.task.note ?: "",
                    onValueChange = viewModel::updateNote,
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    placeholder = { Text("Add Note") })

                HorizontalDivider()
                Row(modifier.padding(16.dp, 8.dp).align(Alignment.CenterHorizontally)) {

                    Text(
                        stringResource(Res.string.created_at) + " " + viewModel.formattedCreatedAt,
                        modifier.weight(1F),
                    )
                    Icon(Icons.Rounded.Delete, "Delete")
                }
            }
        }
    }
}