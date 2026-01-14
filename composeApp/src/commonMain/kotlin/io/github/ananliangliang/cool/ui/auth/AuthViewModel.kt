package io.github.ananliangliang.cool.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.ananliangliang.cool.data.remote.ApiService
import io.github.ananliangliang.cool.data.remote.AuthService
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authService: AuthService
) : ViewModel() {

    var uiState by mutableStateOf(AuthUiState())
        private set



    fun login(username: String) {
        viewModelScope.launch {
            authService.login(username)
            uiState = uiState.copy(isLoggedIn = true)
        }
    }
}