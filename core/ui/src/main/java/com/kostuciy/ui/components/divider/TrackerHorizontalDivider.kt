package com.kostuciy.ui.components.divider

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kostuciy.ui.theme.TrackerTheme

@Composable
fun TrackerHorizontalDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = modifier,
        color = TrackerTheme.colors.divider,
    )
}
