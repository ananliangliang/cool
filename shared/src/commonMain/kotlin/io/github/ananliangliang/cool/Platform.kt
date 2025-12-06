package io.github.ananliangliang.cool

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform