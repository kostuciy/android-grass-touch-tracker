package com.kostuciy.grasstouchtracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kostuciy.map.navigation.mapScreen
import com.kostuciy.scan.navigation.scanScreen
import com.kostuciy.settings.navigation.settingsGraph
import com.kostuciy.useractivity.navigation.UserActivity
import com.kostuciy.useractivity.navigation.userActivityScreen

@Composable
fun TrackerNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = UserActivity,
    ) {
        userActivityScreen()
        mapScreen()
        scanScreen()
        settingsGraph(navController)
    }
}
