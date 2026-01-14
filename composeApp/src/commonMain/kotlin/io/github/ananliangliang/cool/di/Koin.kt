package io.github.ananliangliang.cool.di

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

val koinModule = module {
    single { httpClient }
    singleOf(::ApiService)
    singleOf(::AuthService)
    viewModelOf(::AuthViewModel)
    viewModelOf(::TaskViewModel)
    viewModelOf(::TaskDetailViewModel)
    viewModelOf(::TaskListViewModel)
    viewModelOf(::ChessViewModel)
}