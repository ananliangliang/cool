package io.github.ananliangliang.cool.ui.app

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AppsScreen(
    navToTodos: () -> Unit = {},
    navToChess: () -> Unit = {},
    navToServer: () -> Unit = {},
) {
    Row {
        Button(onClick = navToTodos) {
            Text("Todo")
        }
        Button(onClick = navToChess) {
            Text("Chess")
        }
        Button(onClick = navToServer) {
            Text("Server")
        }
    }
}