package io.github.ananliangliang.cool.nav

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import cool.composeapp.generated.resources.Res
import cool.composeapp.generated.resources.ic_apps_filled
import cool.composeapp.generated.resources.ic_apps_outlined
import cool.composeapp.generated.resources.ic_home_filled
import cool.composeapp.generated.resources.ic_home_outlined
import cool.composeapp.generated.resources.ic_person_filled
import cool.composeapp.generated.resources.ic_person_outlined
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun CoolNavigationBar(
    backStack: NavBackStack<NavKey>
) {
    data class NavItem(
        val label: String,
        val selectedIcon: DrawableResource,
        val unselectedIcon: DrawableResource,
        val route: NavKey,
    )

    val navItems:List<NavItem> = listOf(
        NavItem("CurrentApp", Res.drawable.ic_home_filled, Res.drawable.ic_home_outlined, Apps.Todo.Task),
        NavItem("Apps", Res.drawable.ic_apps_filled, Res.drawable.ic_apps_outlined, Apps),
        NavItem("My", Res.drawable.ic_person_filled, Res.drawable.ic_person_outlined, Welcome),
    )
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar {
        navItems.forEachIndexed { index, navItem ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) painterResource(navItem.selectedIcon)
                        else painterResource(navItem.unselectedIcon),
                        contentDescription = navItem.label,
                    )
                },
                label = { Text(navItem.label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    backStack.add(navItem.route)
                }

            )
        }

    }



}