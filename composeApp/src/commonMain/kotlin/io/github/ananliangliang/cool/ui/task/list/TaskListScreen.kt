package io.github.ananliangliang.cool.ui.task.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.github.ananliangliang.cool.nav.Apps
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TaskListScreen(
    navController: NavController,
    viewModel: TaskListViewModel = koinViewModel(),
) {
    Box(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        data class Fixed(val name: String, val icon: ImageVector)
        Column {
            listOf(
//                Fixed("My Day", Icons.Rounded.WbSunny),
//                Fixed("Important", Icons.Rounded.StarBorder),
//                Fixed("Plan", Icons.Rounded.CalendarMonth),
//                Fixed("All", Icons.Rounded.AllInclusive),
//                Fixed("Completed", Icons.Outlined.CheckCircle),
//                Fixed("Assign", Icons.Rounded.Person),
                Fixed("Task", Icons.Rounded.Home)
            ).forEach {
                ListItem(
                    { Text(it.name) },
                    Modifier.clickable(true) {
                        navController.navigate(Apps.Todo.Task)
                    },
                    leadingContent = { Icon(it.icon, null) },

                    )
            }
            Spacer(Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))
            viewModel.taskListList.forEach {
                ListItem(
                    { Text(it.name) },
                    leadingContent = { Icon(Icons.Outlined.Home, null) },
                )
            }
        }
    }
}
