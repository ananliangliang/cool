package io.github.ananliangliang.cool

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import io.github.ananliangliang.cool.nav.CoolNavHost
import io.github.ananliangliang.cool.nav.CoolNavigationBar
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme(if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {

        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                CoolNavigationBar(navController)
            },
        ) { paddingValues ->
            Box(Modifier.padding(paddingValues)) {
                CoolNavHost(navController)
            }
        }
    }
}