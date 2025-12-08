package io.github.ananliangliang.cool.nav

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.ananliangliang.cool.dto.todo.Task
import kotlinx.coroutines.launch
import kotlin.time.ExperimentalTime

class CoolNavViewModel() : ViewModel() {

    var uiState by mutableStateOf(CoolNavUiState())
        private set


    fun openApp(route: Any) {
        uiState.navItems[0].route = route
    }

}