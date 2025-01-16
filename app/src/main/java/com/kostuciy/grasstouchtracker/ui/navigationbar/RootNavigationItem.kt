package com.kostuciy.grasstouchtracker.ui.navigationbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.kostuciy.grasstouchtracker.navigation.TopLevelDestinations
import com.kostuciy.ui.components.divider.TrackerVerticalDivider
import com.kostuciy.ui.theme.TrackerTheme

@Suppress("t")
@Composable
fun AdaptiveNavBarItem(
    modifier: Modifier = Modifier,
    destinationItem: TopLevelDestinations,
    isSelected: Boolean,
    isEnabled: Boolean = true,
    isCompact: Boolean = false,
    selectedContainerColor: Color = TrackerTheme.colors.primary,
    unselectedContainerColor: Color = TrackerTheme.colors.background,
    selectedTitleColor: Color = TrackerTheme.colors.text,
    unselectedTitleColor: Color = TrackerTheme.colors.primaryText,
    onClick: (TopLevelDestinations) -> Unit,
) {
    var isOverflow by remember { mutableStateOf(false) }

    val icon =
        destinationItem.let {
            if (isEnabled && isSelected) {
                it.selectedIcon
            } else {
                it.unselectedIcon
            }
        }
    val containerColor =
        if (isEnabled && isSelected) {
            selectedContainerColor
        } else {
            unselectedContainerColor
        }
    val titleColor =
        if (isEnabled && isSelected) {
            selectedTitleColor
        } else {
            unselectedTitleColor
        }
    val titleStyle =
        if (!isOverflow) {
            TrackerTheme.typography.body
        } else {
            TrackerTheme.typography.label
        }

    Box(
        modifier =
            modifier
                .background(containerColor)
                .clickable(isEnabled) { onClick(destinationItem) },
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.padding(TrackerTheme.spacing.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =
                Arrangement.spacedBy(
                    TrackerTheme.spacing.smallest,
                    Alignment.CenterHorizontally,
                ),
        ) {
            Icon(
                modifier = Modifier.size(TrackerTheme.dimens.medium),
                painter = painterResource(icon),
                tint = destinationItem.iconTint,
                contentDescription = stringResource(destinationItem.title),
            )

            if (isCompact) return@Row
            Text(
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = { textLayout ->
                    if (!isOverflow) {
                        isOverflow = textLayout.hasVisualOverflow
                    }
                },
                text = stringResource(destinationItem.title),
                style = titleStyle,
                color = titleColor,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun AdaptiveNavBarItemPreview() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(TrackerTheme.colors.background),
    ) {
        AdaptiveNavBarItem(
            modifier = Modifier.weight(1f),
            isSelected = true,
            isEnabled = true,
            onClick = { },
            destinationItem = TopLevelDestinations.USER_ACTIVITY,
        )
        TrackerVerticalDivider()
        AdaptiveNavBarItem(
            modifier = Modifier.weight(1f),
            isSelected = false,
            isEnabled = true,
            onClick = { },
            destinationItem = TopLevelDestinations.MAP,
        )
        TrackerVerticalDivider()
        AdaptiveNavBarItem(
            modifier = Modifier.weight(1f),
            isSelected = false,
            isEnabled = true,
            onClick = { },
            destinationItem = TopLevelDestinations.SETTINGS,
        )
    }
}
