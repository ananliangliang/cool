package io.github.ananliangliang.cool.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.StickyNote2
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import io.github.ananliangliang.cool.dto.todo.Task


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
                        Icon(Icons.AutoMirrored.Outlined.StickyNote2, "note", modifier.size(16.dp))
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