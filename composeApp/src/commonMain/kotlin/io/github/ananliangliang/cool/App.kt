package io.github.ananliangliang.cool

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.github.ananliangliang.cool.di.koinModule
import io.github.ananliangliang.cool.nav.CoolNavHost
import io.github.ananliangliang.cool.nav.CoolNavigationBar
import io.github.ananliangliang.cool.ui.auth.AuthViewModel
import io.github.ananliangliang.cool.ui.auth.LoginScreen
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(onNavHostReady: suspend (NavController) -> Unit = {}) {
    MaterialTheme(if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {

        val navController = rememberNavController()
        KoinApplication({ modules(koinModule) }) {
            val authViewModel: AuthViewModel = koinViewModel()


//            if (authViewModel.uiState.isLoggedIn)
                Scaffold(
                    bottomBar = {
                        CoolNavigationBar(navController)
                    },
                ) { paddingValues ->
                    Box(Modifier.padding(paddingValues)) {
                        CoolNavHost(navController)
                    }
                }
//            else
//                LoginScreen()
        }

        LaunchedEffect(navController) {
            onNavHostReady(navController)
        }
    }
}