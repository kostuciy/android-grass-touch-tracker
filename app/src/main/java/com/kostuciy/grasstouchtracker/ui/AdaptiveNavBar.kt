package com.kostuciy.grasstouchtracker.ui

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kostuciy.grasstouchtracker.navigation.TopLevelDestinations
import com.kostuciy.ui.theme.TrackerTheme

@Composable
fun AdaptiveNavBar(
    modifier: Modifier = Modifier,
    onItemClick: (TopLevelDestinations) -> Unit,
) {
    var currentRoute by remember {
        mutableStateOf(TopLevelDestinations.USER_ACTIVITY)
    }


}

@Composable
fun RootNavigationBar(
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = TrackerTheme.colors.primary
    ) {

    }
}


@Preview
@Composable
fun AdaptiveNavBarPreview() {
    Box(Modifier.fillMaxSize().background(Color.White)) {
        AdaptiveNavBar(Modifier.fillMaxWidth()) {  }
    }

}
