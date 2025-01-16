package com.kostuciy.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun TrackerTheme(content: @Composable () -> Unit) {
    val colors =
        TrackerColors(
            background = darkGray,
            primary = black,
            secondary = brightGreen,
            divider = gray,
            text = white,
            primaryText = brightGray,
            secondaryText = darkGray,
            paramsText = pink,
            argumentsText = blue,
            annotationText = yellow,
            constructionsText = orange,
        )
    val dimens =
        TrackerDimens(
            small = smallDimen,
            medium = mediumDimen,
            large = largeDimen,
        )
    val spacing =
        TrackerSpacing(
            smallest = smallestSpacing,
            small = smallSpacing,
            medium = mediumSpacing,
            mediumLarge = mediumLargeSpacing,
            large = largeSpacing,
            largest = largestSpacing,
        )
    val typography =
        TrackerTypography(
            title = jetbrainsMonoBig,
            body = jetbrainsMonoMedium,
            label = jetbrainsMonoSmall,
        )

    CompositionLocalProvider {
        LocalColors provides colors
        LocalDimens provides dimens
        LocalSpacing provides spacing
        LocalTypography provides typography
        content()
    }
}

object TrackerTheme {
    val colors: TrackerColors
        @Composable
        get() = LocalColors.current
    val dimens: TrackerDimens
        @Composable
        get() = LocalDimens.current
    val spacing: TrackerSpacing
        @Composable
        get() = LocalSpacing.current
    val typography: TrackerTypography
        @Composable
        get() = LocalTypography.current
}

val LocalColors =
    staticCompositionLocalOf {
        TrackerColors(
            background = darkGray,
            primary = black,
            secondary = brightGreen,
            divider = gray,
            text = white,
            primaryText = brightGray,
            secondaryText = darkGray,
            paramsText = pink,
            argumentsText = blue,
            annotationText = yellow,
            constructionsText = orange,
        )
//        TrackerColors(
//            background = Color.Unspecified,
//            primary = Color.Unspecified,
//            secondary = Color.Unspecified,
//            text = Color.Unspecified,
//            primaryText = Color.Unspecified,
//            secondaryText = Color.Unspecified,
//            paramsText = Color.Unspecified,
//            argumentsText = Color.Unspecified,
//            annotationText = Color.Unspecified,
//            constructionsText = Color.Unspecified,
//        )
    }
val LocalDimens =
    staticCompositionLocalOf {
        TrackerDimens(
            small = smallDimen,
            medium = mediumDimen,
            large = largeDimen,
        )
//        TrackerDimens(
//            small = Dp.Unspecified,
//            medium = Dp.Unspecified,
//            large = Dp.Unspecified,
//        )
    }
val LocalSpacing =
    staticCompositionLocalOf {
        TrackerSpacing(
            smallest = smallestSpacing,
            small = smallSpacing,
            medium = mediumSpacing,
            mediumLarge = mediumLargeSpacing,
            large = largeSpacing,
            largest = largestSpacing,
        )
//        TrackerSpacing(
//            smallest = Dp.Unspecified,
//            small = Dp.Unspecified,
//            medium = Dp.Unspecified,
//            mediumLarge = Dp.Unspecified,
//            large = Dp.Unspecified,
//            largest = Dp.Unspecified,
//        )
    }
val LocalTypography =
    staticCompositionLocalOf {
        TrackerTypography(
            title = jetbrainsMonoBig,
            body = jetbrainsMonoMedium,
            label = jetbrainsMonoSmall,
        )
//        TrackerTypography(
//            title = TextStyle.Default,
//            body = TextStyle.Default,
//            label = TextStyle.Default,
//        )
    }
