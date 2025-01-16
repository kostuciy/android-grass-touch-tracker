package com.kostuciy.grasstouchtracker.ui.navigationbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.BottomAppBarDefaults.windowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kostuciy.grasstouchtracker.navigation.TopLevelDestinations
import com.kostuciy.ui.components.divider.TrackerHorizontalDivider
import com.kostuciy.ui.components.divider.TrackerVerticalDivider
import com.kostuciy.ui.theme.TrackerTheme

@Composable
fun RootNavigationBar(
    modifier: Modifier = Modifier,
    onDestinationClick: (TopLevelDestinations) -> Unit,
    isCurrentDestination: (Any) -> Boolean,
) {
    Column(
        modifier = modifier.background(TrackerTheme.colors.background),
    ) {
        TrackerHorizontalDivider()
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .windowInsetsPadding(windowInsets)
                    .selectableGroup(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TopLevelDestinations.entries.forEachIndexed { index, destination ->
                AdaptiveNavBarItem(
                    modifier =
                        Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                    destinationItem = destination,
                    isSelected = isCurrentDestination(destination),
                    onClick = onDestinationClick,
                )
                if (index == TopLevelDestinations.entries.lastIndex) return@forEachIndexed
                TrackerVerticalDivider()
            }
        }
    }
}

@Preview
@Composable
fun RootNavigationBarPreview() {
    var counter = 0

    Box(
        Modifier
            .fillMaxSize()
            .background(TrackerTheme.colors.background),
    ) {
        RootNavigationBar(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
            onDestinationClick = { },
            isCurrentDestination = {
                counter++ == 0
            },
        )
    }
}
