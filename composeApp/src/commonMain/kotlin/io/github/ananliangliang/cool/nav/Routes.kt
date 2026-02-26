package io.github.ananliangliang.cool.nav

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


val navConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Welcome::class, Welcome.serializer())
            subclass(Apps::class, Apps.serializer())
            subclass(Apps.Todo.Task::class, Apps.Todo.Task.serializer())
            subclass(Apps.Todo.TaskDetail::class, Apps.Todo.TaskDetail.serializer())
            subclass(Apps.Chess::class, Apps.Chess.serializer())
            subclass(Apps.Server::class, Apps.Server.serializer())

        }
    }
}

@Serializable
object Apps : NavKey {
    @Serializable
    object Todo {
        @Serializable
        object Task : NavKey

        @Serializable
        data class TaskDetail(val id: Long) : NavKey
    }

    @Serializable
    data object Chess : NavKey

    @Serializable
    data object Server : NavKey
}

@Serializable
object CurrentApp : NavKey

@Serializable
data object Welcome : NavKey