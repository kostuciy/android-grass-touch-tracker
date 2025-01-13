package com.kostuciy.grasstouchtracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.kostuciy.grasstouchtracker.navigation.TopLevelDestinations
import com.kostuciy.ui.theme.TrackerTheme

@Composable
fun RowScope.AdaptiveNavBarItem(
    modifier: Modifier = Modifier,
    destinationItem: TopLevelDestinations,
    isSelected: Boolean,
    isEnabled: Boolean = true,
    selectedContainerColor: Color = TrackerTheme.colors.primary,
    unselectedContainerColor: Color = TrackerTheme.colors.background,
    iconTint: Color,
    titleStyle: TextStyle = TrackerTheme.typography.body,
    onClick: (TopLevelDestinations) -> Unit,
) {
    val icon = destinationItem.let {
        if (isEnabled && isSelected) it.selectedIcon
        else it.unselectedIcon
    }
    val containerColor =
        if (isEnabled && isSelected) selectedContainerColor
        else unselectedContainerColor

    VerticalDivider()
    Box(
        modifier =
            modifier
                .background(containerColor)
                .clickable(isEnabled) { onClick(destinationItem) }
        ,
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(icon),
                tint = iconTint,
                contentDescription = stringResource(destinationItem.title),
            )
            Text(
                text = stringResource(destinationItem.title),
                style = titleStyle,
            )
        }
    }
    VerticalDivider()
}

@Preview
@Composable
fun AdaptiveNavBarItemPreview() {
    Row(Modifier.fillMaxWidth().background(TrackerTheme.colors.primary)) {
        AdaptiveNavBarItem(
            isSelected = true,
            isEnabled = true,
            onClick = { },
            destinationItem = TopLevelDestinations.USER_ACTIVITY,
            iconTint = Color.Cyan,
            titleStyle = TrackerTheme.typography.body
        )
    }
}
