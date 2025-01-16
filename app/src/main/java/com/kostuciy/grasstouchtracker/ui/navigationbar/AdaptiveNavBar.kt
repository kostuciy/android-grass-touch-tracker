package com.kostuciy.grasstouchtracker.ui.navigationbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AdaptiveNavBar(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

//    * TODO: add screen width check
    RootNavigationBar(
        modifier = modifier,
        onDestinationClick = { },
        isCurrentDestination = { route ->
            currentDestination?.hierarchy?.any {
                it.hasRoute(route = route::class)
            } ?: false
        },
    )
}
