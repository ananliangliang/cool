package io.github.ananliangliang.cool.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.ananliangliang.cool.ui.AppsScreen
import io.github.ananliangliang.cool.ui.CurrentAppScreen
import io.github.ananliangliang.cool.ui.WelcomeScreen

@Composable
fun CoolNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Welcome) {
        composable<Welcome> { WelcomeScreen() }
        composable<CurrentApp> { CurrentAppScreen() }
        composable<Apps> { AppsScreen() }
        composable<CurrentApp> { CurrentAppScreen() }
    }
}
