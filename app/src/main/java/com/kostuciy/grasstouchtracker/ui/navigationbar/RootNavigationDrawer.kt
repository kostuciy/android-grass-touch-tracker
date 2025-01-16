@file:Suppress("ktlint:standard:no-unused-imports")

package com.kostuciy.grasstouchtracker.ui.navigationbar

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.kostuciy.grasstouchtracker.navigation.TopLevelDestinations
import com.kostuciy.ui.components.divider.TrackerHorizontalDivider
import com.kostuciy.ui.components.divider.TrackerVerticalDivider
import com.kostuciy.ui.theme.TrackerTheme
import com.kostuciy.ui.R as UiR

@Composable
fun RootNavigationDrawer(
    modifier: Modifier = Modifier,
    onDestinationClick: (TopLevelDestinations) -> Unit,
    compactInitially: Boolean = true,
    isCurrentDestination: (Any) -> Boolean,
    content: @Composable () -> Unit,
) {
    var isCompact by remember {
        mutableStateOf(compactInitially)
    }

    PermanentNavigationDrawer(
        modifier = modifier,
        content = content,
        drawerContent = {
            RootNavigationDrawerContent(
                isCompact = isCompact,
                isCurrentDestination = isCurrentDestination,
                onDestinationClick = onDestinationClick,
                onMoreClick = { isCompact = !isCompact },
            )
        },
    )
}

@Composable
fun RootNavigationDrawerContent(
    contentScrollState: ScrollState = rememberScrollState(),
    isCompact: Boolean,
    isCurrentDestination: (Any) -> Boolean,
    onDestinationClick: (TopLevelDestinations) -> Unit,
    onMoreClick: () -> Unit,
) {
    Row(
        Modifier
            .fillMaxHeight()
            .width(IntrinsicSize.Min)
            .background(TrackerTheme.colors.background),
    ) {
        Column(
            modifier =
                Modifier
                    .verticalScroll(contentScrollState)
                    .width(IntrinsicSize.Min),
        ) {
            MoreDrawerButton(
                isCompact = isCompact,
                onClick = onMoreClick,
            )

            TopLevelDestinations.entries.forEachIndexed { index, destination ->
                AdaptiveNavBarItem(
                    modifier = Modifier.fillMaxWidth(),
                    destinationItem = destination,
                    isSelected = isCurrentDestination(destination),
                    isCompact = isCompact,
                    onClick = onDestinationClick,
                )
                TrackerHorizontalDivider()
            }
        }
        TrackerVerticalDivider()
    }
}

@Composable
fun MoreDrawerButton(
    modifier: Modifier = Modifier,
    isCompact: Boolean,
    onClick: () -> Unit,
) {
    val textRes = if (isCompact) UiR.string.plus else UiR.string.minus
    val alignment = if (isCompact) Alignment.Center else Alignment.CenterEnd

    Box(
        Modifier
            .fillMaxWidth()
            .padding(
                vertical = TrackerTheme.spacing.smallest,
            ),
    ) {
        Text(
            modifier =
                Modifier
                    .align(alignment)
                    .padding(TrackerTheme.spacing.smallest)
                    .clickable { onClick() },
            text = stringResource(textRes),
            color = TrackerTheme.colors.text,
            style = TrackerTheme.typography.title,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(device = Devices.AUTOMOTIVE_1024p, widthDp = 720, heightDp = 360)
@Composable
fun RootNavigationDrawerPreview() {
    var counter = 0
    RootNavigationDrawer(
        compactInitially = false,
        onDestinationClick = {},
        isCurrentDestination = { counter++ == 0 },
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(TrackerTheme.colors.background),
        )
    }
}
