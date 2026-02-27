package io.github.ananliangliang.cool

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.rememberNavBackStack
import io.github.ananliangliang.cool.di.application
import io.github.ananliangliang.cool.nav.Apps
import io.github.ananliangliang.cool.nav.CoolNavDisplay
import io.github.ananliangliang.cool.nav.CoolNavigationBar
import io.github.ananliangliang.cool.nav.navConfig
import io.github.ananliangliang.cool.ui.auth.AuthViewModel
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme(if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {

        KoinApplication(application) {
            val authViewModel: AuthViewModel = koinViewModel()


//            if (authViewModel.uiState.isLoggedIn)
            val backStack = rememberNavBackStack(navConfig, Apps.Chess)
                Scaffold(
                    bottomBar = {
                        CoolNavigationBar(backStack)
                    },
                ) { paddingValues ->
                    Box(Modifier.padding(paddingValues)) {
                        CoolNavDisplay(backStack)
                    }
                }
//            else
//                LoginScreen()
        }

    }
}