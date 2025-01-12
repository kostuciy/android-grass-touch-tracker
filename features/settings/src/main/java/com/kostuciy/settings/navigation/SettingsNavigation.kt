package com.kostuciy.settings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kostuciy.settings.editprofile.composables.EditProfileScreen
import com.kostuciy.settings.general.composables.GeneralSettingsScreen
import kotlinx.serialization.Serializable

@Serializable
data object SettingsGraph

@Serializable
data object GeneralSettings

@Serializable
data object EditProfile

fun NavGraphBuilder.generalSettingsScreen() {
    composable<GeneralSettings> { GeneralSettingsScreen() }
}

fun NavGraphBuilder.editProfileScreen() {
    composable<EditProfile> { EditProfileScreen() }
}

fun NavGraphBuilder.settingsGraph(navController: NavController) {
    navigation<SettingsGraph>(startDestination = GeneralSettings) {
        generalSettingsScreen()
        editProfileScreen()
    }
}
