package io.github.ananliangliang.cool.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector


data class CoolNavUiState(
    val navItems: List<NavItem> = mutableListOf(
        NavItem("CurrentApp", Icons.Filled.Home, Icons.Outlined.Home, Apps.Todo.Task),
        NavItem("Apps", Icons.Filled.Apps, Icons.Outlined.Apps, Apps),
        NavItem("My", Icons.Filled.Person, Icons.Outlined.Person, Welcome),
    )
) {
    data class NavItem(
        val label: String,
        val selectedIcon: ImageVector,
        val unselectedIcon: ImageVector,
        var route: Any,
    )
}