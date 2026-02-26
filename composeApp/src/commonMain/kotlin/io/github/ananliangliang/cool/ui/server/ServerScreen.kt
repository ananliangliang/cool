package io.github.ananliangliang.cool.ui.server

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester
import io.github.ananliangliang.cool.util.exec

@Composable
fun ServerScreen() {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        exec()
    }

}