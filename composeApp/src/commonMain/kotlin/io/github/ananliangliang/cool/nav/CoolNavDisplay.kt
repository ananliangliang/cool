package io.github.ananliangliang.cool.nav

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import io.github.ananliangliang.cool.ui.app.AppsScreen
import io.github.ananliangliang.cool.ui.app.WelcomeScreen
import io.github.ananliangliang.cool.ui.chess.ChessScreen
import io.github.ananliangliang.cool.ui.server.ServerScreen
import io.github.ananliangliang.cool.ui.task.TaskScreen
import io.github.ananliangliang.cool.ui.task.detail.TaskDetailScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


@Composable
fun CoolNavDisplay(backStack: NavBackStack<NavKey>) {
    val entryProvider = entryProvider {
        entry<Welcome> { WelcomeScreen() }
        entry<Apps> {
            AppsScreen(
                { backStack.add(Apps.Todo.Task) },
                { backStack.add(Apps.Chess) },
                { backStack.add(Apps.Server) },
            )
        }
        entry<Apps.Todo.Task> {
            TaskScreen(
                {backStack.removeLastOrNull()},
                { id -> backStack.add(Apps.Todo.TaskDetail(id)) }

        )
        }
        entry<Apps.Todo.TaskDetail> { navKey ->
            TaskDetailScreen(  navKey.id, {backStack.removeLastOrNull()},)
        }
        entry<Apps.Chess> { ChessScreen() }
        entry<Apps.Server> { ServerScreen() }

    }
    NavDisplay(backStack, entryProvider = entryProvider)

}
