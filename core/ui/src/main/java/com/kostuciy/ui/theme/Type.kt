package com.kostuciy.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kostuciy.ui.R

@OptIn(ExperimentalTextApi::class)
val jetbrainsMonoFontFamily =
    FontFamily(
        Font(
            resId = R.font.jetbrains_mono_variable,
            variationSettings =
                FontVariation.Settings(
                    FontVariation.weight(300), // TODO: change if needs to be changed to 400
                ),
        ),
    )

@Immutable
data class TrackerTypography(
    val title: TextStyle,
    val body: TextStyle,
    val label: TextStyle,
)

val jetbrainsMonoBig =
    TextStyle(
        fontFamily = jetbrainsMonoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
    )
val jetbrainsMonoMedium =
    TextStyle(
        fontFamily = jetbrainsMonoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    )
val jetbrainsMonoSmall =
    TextStyle(
        fontFamily = jetbrainsMonoFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    )
