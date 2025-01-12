package com.kostuciy.scan.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kostuciy.scan.scan.composables.ScanScreen
import kotlinx.serialization.Serializable

@Serializable
data object Scan

fun NavGraphBuilder.scanScreen() {
    composable<Scan> { ScanScreen() }
}
