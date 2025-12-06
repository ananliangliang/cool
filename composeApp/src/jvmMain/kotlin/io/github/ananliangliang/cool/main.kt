package io.github.ananliangliang.cool

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "cool",
    ) {
        App()
    }
}