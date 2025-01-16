package com.kostuciy.ui.components.divider

import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kostuciy.ui.theme.TrackerTheme

@Composable
fun TrackerVerticalDivider(modifier: Modifier = Modifier) {
    VerticalDivider(
        modifier = modifier,
        color = TrackerTheme.colors.divider,
    )
}
