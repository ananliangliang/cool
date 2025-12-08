package io.github.ananliangliang.cool.nav

import kotlinx.serialization.Serializable


@Serializable
object Apps {
    @Serializable
    object Todo {
        @Serializable
        object Task
        @Serializable
        data class TaskDetail(val id: Long)
    }
    @Serializable
    object Chess {

    }
}
@Serializable
object My
@Serializable
object CurrentApp
@Serializable
object Welcome