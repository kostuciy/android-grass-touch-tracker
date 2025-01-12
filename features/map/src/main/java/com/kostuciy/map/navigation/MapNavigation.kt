package com.kostuciy.map.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kostuciy.map.map.composables.MapScreen
import kotlinx.serialization.Serializable

@Serializable
data object Map

fun NavGraphBuilder.mapScreen() {
    composable<Map> { MapScreen() }
}
