package com.dimaklekchyan.wizardium.design_system.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun DSTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val typography = getDSTypography()

    CompositionLocalProvider(
        LocalDSDarkMode provides isDarkMode,
        LocalDSColorsProvider provides if (isDarkMode) darkFrontDesignPalette else lightFrontDesignPalette,
        LocalDSTypographyProvider provides typography,
        LocalDSPaddingsProvider provides paddings,
        LocalDSShapesProvider provides shapes,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides LocalDSColorsProvider.current.textPrimary
        ) {
            content()
        }
    }
}

val LocalDSDarkMode = staticCompositionLocalOf<Boolean> {
    error("No DSDarkMode provided")
}

object DSTheme {
    val colors: DSColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDSColorsProvider.current
    val typography: DSTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDSTypographyProvider.current
    val paddings: DSPaddings
        @Composable
        @ReadOnlyComposable
        get() = LocalDSPaddingsProvider.current
    val shapes: DSShape
        @Composable
        @ReadOnlyComposable
        get() = LocalDSShapesProvider.current
}

