package io.github.ananliangliang.cool.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

actual suspend fun execOnWindows(vararg command: String): Unit = withContext(Dispatchers.IO) {
    if (System.getProperty("os.name").uppercase().contains("WINDOWS"))
        ProcessBuilder(*command)
            .inheritIO()
            .start()
            .waitFor()
}
