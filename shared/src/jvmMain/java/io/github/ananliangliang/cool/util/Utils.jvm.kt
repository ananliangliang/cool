package io.github.ananliangliang.cool.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext

actual suspend fun exec(vararg command: String): Unit = withContext(Dispatchers.IO) {
    isActive
    println(System.getProperty("os.name"))

    "netsh interface portproxy add v4tov4 " +
            "listenport=22 listenaddress=0.0.0.0 connectport=22 connectaddress=ubuntu.mshome.net"
    ProcessBuilder("ping", "www.baidu.com")
        .inheritIO()
        .start()
        .waitFor()
}
