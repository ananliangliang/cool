package io.github.ananliangliang.cool.ui.app

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import io.github.ananliangliang.cool.nav.Apps
import io.github.ananliangliang.cool.nav.CurrentApp

@Composable
fun AppsScreen(
    navController: NavController,
) {
    Row {
        Button(onClick = { navController.navigate(CurrentApp) }) {
            Text("Todo")
        }
        Button(onClick = { navController.navigate(Apps.Chess) }) {
            Text("Chess")
        }
    }
}