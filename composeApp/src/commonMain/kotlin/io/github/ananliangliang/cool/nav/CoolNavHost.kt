package io.github.ananliangliang.cool.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import io.github.ananliangliang.cool.ui.app.AppsScreen
import io.github.ananliangliang.cool.ui.app.MyScreen
import io.github.ananliangliang.cool.ui.chess.ChessScreen
import io.github.ananliangliang.cool.ui.task.TaskScreen
import io.github.ananliangliang.cool.ui.task.detail.TaskDetailScreen

@Composable
fun CoolNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Welcome) {
        composable<Welcome> { MyScreen() }
        composable<Apps.Todo.Task> { TaskScreen(navController) }
        composable<Apps> { AppsScreen(navController) }
        composable<Apps.Todo.TaskDetail> {
            val args = it.toRoute<Apps.Todo.TaskDetail>()
            TaskDetailScreen(navController, args.id)
        }
        composable<Apps.Chess> { ChessScreen() }
    }
}
