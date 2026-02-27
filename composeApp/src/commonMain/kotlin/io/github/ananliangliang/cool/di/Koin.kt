package io.github.ananliangliang.cool.di

import androidx.compose.runtime.Composable
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import io.github.ananliangliang.cool.data.remote.ApiService
import io.github.ananliangliang.cool.data.remote.AuthService
import io.github.ananliangliang.cool.data.remote.httpClient
import io.github.ananliangliang.cool.ui.auth.AuthViewModel
import io.github.ananliangliang.cool.ui.chess.ChessViewModel
import io.github.ananliangliang.cool.ui.task.TaskViewModel
import io.github.ananliangliang.cool.ui.task.detail.TaskDetailViewModel
import io.github.ananliangliang.cool.ui.task.list.TaskListViewModel
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration

private val koinModule = module {
    single { httpClient }
    singleOf(::ApiService)
    singleOf(::AuthService)
    viewModelOf(::AuthViewModel)
    viewModelOf(::TaskViewModel)
    viewModelOf(::TaskDetailViewModel)
    viewModelOf(::TaskListViewModel)
    viewModelOf(::ChessViewModel)
}

val application: KoinAppDeclaration = { modules(koinModule) }

@Composable
fun KoinScreenPreview(content: @Composable () -> Unit) {
    KoinApplication(application) { content() }
}