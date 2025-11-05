package com.dimaklekchyan.wizardium.design_system.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import wizardium.common.res.generated.resources.Res
import wizardium.common.res.generated.resources.inter_bold
import wizardium.common.res.generated.resources.inter_medium
import wizardium.common.res.generated.resources.inter_regular
import wizardium.common.res.generated.resources.playfair_display_bold
import wizardium.common.res.generated.resources.playfair_display_medium

@Immutable
data class DSTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    
    val body: TextStyle,
    val bodyMedium: TextStyle,
    val bodyBold: TextStyle,
    val bodySmall: TextStyle,
    val bodySmallMedium: TextStyle,
    val bodySmallBold: TextStyle,
    
    val caption: TextStyle,
    val captionBold: TextStyle,
)

val LocalDSTypographyProvider = staticCompositionLocalOf<DSTypography> {
    error("No DSTypography provided")
}

@Composable
internal fun getDSTypography(): DSTypography {
    val interFontFamily = FontFamily(
        Font(Res.font.inter_regular, FontWeight.Normal),
        Font(Res.font.inter_medium, FontWeight.Medium),
        Font(Res.font.inter_bold, FontWeight.Bold)
    )

    val playfairDisplayFontFamily = FontFamily(
        Font(Res.font.playfair_display_medium, FontWeight.W600),
        Font(Res.font.playfair_display_bold, FontWeight.Bold)
    )

    return DSTypography(
        h1 = TextStyle(
            fontSize = 32.sp,
            lineHeight = 38.sp,
            fontFamily = playfairDisplayFontFamily,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.02.em
        ),
        h2 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 31.sp,
            fontFamily = playfairDisplayFontFamily,
            fontWeight = FontWeight.W600,
            letterSpacing = 0.02.em
        ),
        h3 = TextStyle(
            fontSize = 18.sp,
            lineHeight = 25.sp,
            fontFamily = playfairDisplayFontFamily,
            fontWeight = FontWeight.W600,
            letterSpacing = 0.02.em
        ),
        body = TextStyle(
            fontSize = 16.sp,
            lineHeight = 26.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal
        ),
        bodyMedium = TextStyle(
            fontSize = 16.sp,
            lineHeight = 26.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Medium
        ),
        bodyBold = TextStyle(
            fontSize = 16.sp,
            lineHeight = 26.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Bold
        ),
        bodySmall = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal
        ),
        bodySmallMedium = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Medium
        ),
        bodySmallBold = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Bold
        ),
        caption = TextStyle(
            fontSize = 12.sp,
            lineHeight = 17.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal
        ),
        captionBold = TextStyle(
            fontSize = 12.sp,
            lineHeight = 17.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Bold
        ),
    )
}
