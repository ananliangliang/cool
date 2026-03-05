package io.github.ananliangliang.cool.ui.server

import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import io.github.ananliangliang.cool.util.execOnWindows
import io.ktor.util.PlatformUtils
import io.ktor.util.platform
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun ServerScreen() {
    var start by remember { mutableStateOf(false) }
    if (PlatformUtils.IS_JVM.not())
        Text("Cannot run server on ${PlatformUtils.platform}")
    else
        Switch(start, { start = it })



    LaunchedEffect(start) {
        if (start) {
            while (isActive) {
                delay(3000)
                execOnWindows(
                    "powershell", "-Command", "\"Start-Process -FilePath 'netsh' -Verb RunAs " +
                            "-ArgumentList 'interface', 'portproxy', 'add', 'v4tov4', 'listenport=22', '" +
                            "listenaddress=0.0.0.0', 'connectport=22', 'connectaddress=ubuntu.mshome.net'\""
                )
                println("Port proxy set")
            }
        }
    }

}