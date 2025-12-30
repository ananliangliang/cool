package io.github.ananliangliang.cool.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.github.ananliangliang.cool.data.remote.ApiService

class AuthViewModel(
    private val apiService: ApiService
) : ViewModel() {

    var uiState by mutableStateOf(AuthUiState())
        private set



    fun login(username: String) {
    }
}