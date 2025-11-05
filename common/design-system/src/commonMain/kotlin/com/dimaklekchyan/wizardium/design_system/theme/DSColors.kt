package com.dimaklekchyan.wizardium.design_system.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class DSColors(
    val brandPrimary: Color,
    val brandSecondary: Color,
    val brandTertiary: Color,

    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textInverseWhite: Color,
    val textInverseBlack: Color,

    val backgroundPrimary: Color,
    val backgroundSecondary: Color,
    val backgroundIllustration: Color,

    val surface: Color,
    val border: Color,
)

val LocalDSColorsProvider = staticCompositionLocalOf<DSColors> {
    error("No DSColors provided")
}

val beige2_5 = Color(0xFFFFFCFA)
val beige05 = Color(0xFFFDFAF7)
val beige10 = Color(0xFFF7F3EE)
val beige20 = Color(0xFFF0EBE6)
val beige30 = Color(0xFFE5DFD8)
val beige40 = Color(0xFFD4CCC3)
val beige50 = Color(0xFFB8AEA3)
val beige60 = Color(0xFF9A8E83)
val beige70 = Color(0xFF7A6E63)
val beige80 = Color(0xFF5A4F46)
val beige90 = Color(0xFF3A312A)
val beige95 = Color(0xFF252220)

// Dark Brown Palette (for dark theme)
val brown2_5 = Color(0xFF2A2522)
val brown05 = Color(0xFF252220)
val brown10 = Color(0xFF1A1716)
val brown20 = Color(0xFF151311)
val brown30 = Color(0xFF0E0B0A)
val brown40 = Color(0xFF0A0807)
val brown50 = Color(0xFF070605)
val brown60 = Color(0xFF050403)
val brown70 = Color(0xFF030302)
val brown80 = Color(0xFF020201)
val brown90 = Color(0xFF010100)

val maroon2_5 = Color(0xFFFEF5F5)
val maroon05 = Color(0xFFFDE8E8)
val maroon10 = Color(0xFFFAD5D5)
val maroon20 = Color(0xFFF4B3B3)
val maroon30 = Color(0xFFE88585)
val maroon40 = Color(0xFFD66060)
val maroon50 = Color(0xFF9A3E3E) // Dark theme variant
val maroon60 = Color(0xFF7A2E2E) // Light theme variant
val maroon70 = Color(0xFF5A2222)
val maroon80 = Color(0xFF4A1C1C)
val maroon90 = Color(0xFF3A1616)

val gold2_5 = Color(0xFFFFFBF5)
val gold05 = Color(0xFFFFF7ED)
val gold10 = Color(0xFFFFEFD5)
val gold20 = Color(0xFFFFE4B8)
val gold30 = Color(0xFFFFD99A)
val gold40 = Color(0xFFE6B05F) // Dark theme variant
val gold50 = Color(0xFFD6A04F) // Light theme variant
val gold60 = Color(0xFFC0903F)
val gold70 = Color(0xFFAA802F)
val gold80 = Color(0xFF94701F)
val gold90 = Color(0xFF7E600F)

val green2_5 = Color(0xFFF5F9F7)
val green05 = Color(0xFFEBF3EF)
val green10 = Color(0xFFD7E7DF)
val green20 = Color(0xFFB3CFBF)
val green30 = Color(0xFF8FB79F)
val green40 = Color(0xFF3E6F54) // Dark theme variant
val green50 = Color(0xFF2E5F44) // Light theme variant
val green60 = Color(0xFF264F3A)
val green70 = Color(0xFF1E3F30)
val green80 = Color(0xFF162F26)
val green90 = Color(0xFF0E1F1C)

val purple2_5 = Color(0xFFF9F8FB)
val purple05 = Color(0xFFF3F1F7)
val purple10 = Color(0xFFE7E3EF)
val purple20 = Color(0xFFCFC7DF)
val purple30 = Color(0xFFB7ABCF)
val purple40 = Color(0xFF6A5C9C)
val purple50 = Color(0xFF5A4B8C)
val purple60 = Color(0xFF4A3B7C)
val purple70 = Color(0xFF3A2B6C)
val purple80 = Color(0xFF2A1B5C)
val purple90 = Color(0xFF1A0B4C)

val blue2_5 = Color(0xFFF5FAFF)
val blue05 = Color(0xFFEFF8FF)
val blue10 = Color(0xFFD1E9FF)
val blue20 = Color(0xFFB6E3FF)
val blue30 = Color(0xFF80CCFF)
val blue40 = Color(0xFF54AEFF)
val blue50 = Color(0xFF218BFF)
val blue60 = Color(0xFF155EEF)
val blue70 = Color(0xFF0550AE)
val blue80 = Color(0xFF033D8B)
val blue90 = Color(0xFF0A3069)

// Text Colors - Light Theme
val textLightPrimary = Color(0xFF1F1B18)
val textLightSecondary = Color(0xFF6E665F)
val textLightTertiary = Color(0xFF9A8E83)

// Text Colors - Dark Theme
val textDarkPrimary = Color(0xFFEDEBE8)
val textDarkSecondary = Color(0xFFB1A9A2)
val textDarkTertiary = Color(0xFF7A6E63)

val lightFrontDesignPalette = DSColors(
    brandPrimary = maroon60,
    brandSecondary = gold50,
    brandTertiary = green50,

    textPrimary = textLightPrimary,
    textSecondary = textLightSecondary,
    textTertiary = textLightTertiary,
    textInverseWhite = Color(0xFFFFFFFF),
    textInverseBlack = textLightPrimary,

    backgroundPrimary = beige10,
    backgroundSecondary = beige20,
    backgroundIllustration = beige10.copy(alpha = 0.2f),

    surface = Color(0xFFFFFFFF),
    border = beige30,
)

val darkFrontDesignPalette = DSColors(
    brandPrimary = maroon50,
    brandSecondary = gold40,
    brandTertiary = green40,

    textPrimary = textDarkPrimary,
    textSecondary = textDarkSecondary,
    textTertiary = textDarkTertiary,
    textInverseWhite = Color(0xFFFFFFFF),
    textInverseBlack = textLightPrimary,

    backgroundPrimary = brown30,
    backgroundSecondary = brown10,
    backgroundIllustration = brown30.copy(alpha = 0.2f),

    surface = brown10,
    border = brown2_5,
)

