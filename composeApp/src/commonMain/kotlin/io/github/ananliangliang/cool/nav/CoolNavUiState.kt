package io.github.ananliangliang.cool.nav

import androidx.compose.ui.graphics.vector.ImageVector


data class CoolNavUiState(
    val navItems: List<NavItem> = mutableListOf(
//        NavItem("CurrentApp", Image(painterResource(Res.home)), Icons.Outlined.Home, Apps.Todo.Task),
//        NavItem("Apps", Icons.Filled.Apps, Icons.Outlined.Apps, Apps),
//        NavItem("My", Icons.Filled.Person, Icons.Outlined.Person, Welcome),
    )
) {
    data class NavItem(
        val label: String,
        val selectedIcon: ImageVector,
        val unselectedIcon: ImageVector,
        var route: Any,
    )
}