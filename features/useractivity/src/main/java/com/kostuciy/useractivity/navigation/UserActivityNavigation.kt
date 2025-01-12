package com.kostuciy.useractivity.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kostuciy.useractivity.useractivity.composables.UserActivityScreen
import kotlinx.serialization.Serializable

@Serializable
data object UserActivity

fun NavGraphBuilder.userActivityScreen() {
    composable<UserActivity> { UserActivityScreen() }
}
