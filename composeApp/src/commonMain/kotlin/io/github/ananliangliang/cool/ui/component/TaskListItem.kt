package io.github.ananliangliang.cool.ui.component


import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import cool.composeapp.generated.resources.Res
import cool.composeapp.generated.resources.ic_sticky_note_2
import io.github.ananliangliang.cool.dto.todo.Task
import org.jetbrains.compose.resources.painterResource


@Composable
fun TaskListItem(
    task: Task,
    onCompleted: () -> Unit,
    onImportant: () -> Unit,
    onDelete: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberSwipeToDismissBoxState()
    if (state.currentValue == SwipeToDismissBoxValue.EndToStart) onDelete()
    SwipeToDismissBox(
        state,
        {
            val color by animateColorAsState(
                when (state.targetValue) {
                    SwipeToDismissBoxValue.Settled -> Color.LightGray
                    SwipeToDismissBoxValue.StartToEnd -> Color.Green
                    SwipeToDismissBoxValue.EndToStart -> MaterialTheme.colorScheme.error
                }
            )
            Box(Modifier.fillMaxSize().background(color))
        },
        modifier,
        enableDismissFromStartToEnd = false
    ) {
        ListItem(
            {
                Text(
                    text = task.name!!,
                    textDecoration = if (task.isCompleted == true) TextDecoration.LineThrough else null,
                )
            },
            modifier.clickable { onClick() },
            supportingContent = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    task.note?.let {
                        Icon(painterResource(Res.drawable.ic_sticky_note_2), "note", modifier.size(16.dp))
                    }
                    Spacer(modifier.size(4.dp))
                }
            },
            leadingContent = {
                TaskCompleteCheckBox(
                    checked = task.isCompleted == true,
                    onClick = { onCompleted() },
                )
            },
            trailingContent = {
                TaskImportantCheckBox(task.isImportant == true, onClick = { onImportant() })
            },
        )
    }

}