package io.github.ananliangliang.cool.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import io.github.ananliangliang.cool.data.network.ApiService
import io.github.ananliangliang.cool.data.network.httpClient
import io.github.ananliangliang.cool.ui.task.TaskViewModel
import io.github.ananliangliang.cool.ui.task.detail.TaskDetailViewModel
import io.github.ananliangliang.cool.ui.task.list.TaskListViewModel

val koinModule = module {
    single { httpClient }
    singleOf(::ApiService)
    viewModelOf(::TaskViewModel)
    viewModelOf(::TaskDetailViewModel)
    viewModelOf(::TaskListViewModel)
}