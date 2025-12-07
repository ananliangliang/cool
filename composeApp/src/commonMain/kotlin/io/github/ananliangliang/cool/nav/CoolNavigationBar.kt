package io.github.ananliangliang.cool.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

@Composable
fun CoolNavigationBar(
    navController: NavController
) {
    data class NavItem(
        val label: String,
        val selectedIcon: ImageVector,
        val unselectedIcon: ImageVector,
        val route: Any,
    )
    val navItems = listOf(
        NavItem("CurrentApp", Icons.Filled.Home, Icons.Outlined.Home, CurrentApp),
        NavItem("Apps", Icons.Filled.Apps, Icons.Outlined.Apps, Apps),
        NavItem("My", Icons.Filled.Person, Icons.Outlined.Person, Welcome),
    )
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar {
        navItems.forEachIndexed { index, navItem ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) navItem.selectedIcon else navItem.unselectedIcon,
                        contentDescription = navItem.label,
                    )
                },
                label = { Text(navItem.label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(navItem.route)
                }

            )
        }

    }



}