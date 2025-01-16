package com.kostuciy.grasstouchtracker.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.kostuciy.map.navigation.Map
import com.kostuciy.settings.navigation.SettingsGraph
import com.kostuciy.useractivity.navigation.UserActivity
import com.kostuciy.map.R as mapR
import com.kostuciy.settings.R as settingsR
import com.kostuciy.useractivity.R as activityR

enum class TopLevelDestinations(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val iconTint: Color,
    @StringRes val title: Int,
    val route: Any,
) {
    USER_ACTIVITY(
        selectedIcon = activityR.drawable.baseline_home_filled_24,
        unselectedIcon = activityR.drawable.outline_home_24,
        title = activityR.string.destination_user_activity,
        route = UserActivity,
        iconTint = Color(0xFFDC6142),
    ),

    MAP(
        selectedIcon = mapR.drawable.outline_map_24,
        unselectedIcon = mapR.drawable.baseline_map_24,
        title = mapR.string.destination_map,
        route = Map,
        iconTint = Color(0xFF1BDC98),
    ),

    SETTINGS(
        selectedIcon = settingsR.drawable.baseline_settings_24,
        unselectedIcon = settingsR.drawable.outline_settings_24,
        title = settingsR.string.destination_settings,
        route = SettingsGraph,
        iconTint = Color(0xFF2AB8E3),
    ),
}
