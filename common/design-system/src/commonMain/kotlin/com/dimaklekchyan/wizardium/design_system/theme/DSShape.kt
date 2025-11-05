package com.dimaklekchyan.wizardium.design_system.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class DSShape(
    val xs: RoundedCornerShape,
    val s: RoundedCornerShape,
    val m: RoundedCornerShape,
    val l: RoundedCornerShape,
    val xl: RoundedCornerShape,
    val xxl: RoundedCornerShape,
    val circle: RoundedCornerShape
)

val LocalDSShapesProvider = staticCompositionLocalOf<DSShape> {
    error("No DSShape provided")
}

internal val shapes = DSShape(
    xs = RoundedCornerShape(2.dp),
    s = RoundedCornerShape(4.dp),
    m = RoundedCornerShape(6.dp),
    l = RoundedCornerShape(8.dp),
    xl = RoundedCornerShape(12.dp),
    xxl = RoundedCornerShape(16.dp),
    circle = CircleShape
)