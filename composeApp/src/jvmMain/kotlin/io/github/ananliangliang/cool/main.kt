package io.github.ananliangliang.cool

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(size = DpSize(320.dp, 640.dp)),
        title = "cool",
    ) {
        window.minimumSize = Dimension(320, 480)
        App()
    }
}