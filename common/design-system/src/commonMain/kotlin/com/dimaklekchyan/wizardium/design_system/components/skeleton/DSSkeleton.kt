package com.dimaklekchyan.wizardium.design_system.components.skeleton

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.dimaklekchyan.wizardium.design_system.theme.DSTheme
import com.dimaklekchyan.wizardium.design_system.theme.LocalDSDarkMode
import com.dimaklekchyan.wizardium.design_system.theme.beige20
import com.dimaklekchyan.wizardium.design_system.theme.brown05
import org.jetbrains.compose.ui.tooling.preview.Preview

internal val lightSkeletonTheme = DSRippleSkeletonTheme(
    firstColor = beige20.copy(alpha = 0.6f),
    secondColor = beige20.copy(alpha = 0.2f)
)
internal val darkSkeletonTheme = DSRippleSkeletonTheme(
    firstColor = brown05.copy(alpha = 0.8f),
    secondColor = brown05.copy(alpha = 0.25f)
)

class DSRippleSkeletonTheme(
    val firstColor: Color,
    val secondColor: Color
)

@Composable
fun DSSkeleton(
    modifier: Modifier = Modifier,
    shape: Shape = DSTheme.shapes.m,
) {

    Box(
        modifier = modifier
            .clip(shape)
            .dsRippleSkeleton(shape)
    )
}

@Composable
fun Modifier.dsRippleSkeleton(
    shape: Shape = DSTheme.shapes.m
): Modifier {
    val isDarkMode = LocalDSDarkMode.current
    val theme = remember(isDarkMode) {
        if (isDarkMode) darkSkeletonTheme else lightSkeletonTheme
    }
    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation by transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearOutSlowInEasing,
            ),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "",
    )

    return drawWithContent {
        val density = Density(
            density = density,
            fontScale = fontScale
        )
        val outline = shape.createOutline(
            size = size,
            layoutDirection = layoutDirection,
            density = density
        )
        val cornerRadius = if (outline is Outline.Rounded) {
            outline.roundRect.bottomLeftCornerRadius
        } else {
            CornerRadius(0f)
        }
        val color = lerp(
            start = theme.firstColor,
            stop = theme.secondColor,
            fraction = translateAnimation
        )
        drawRoundRect(
            color = color,
            cornerRadius = cornerRadius
        )
    }
}

@Preview
@Composable
private fun DSSkeletonPreview() {
    var isDarkMode by remember { mutableStateOf(false) }

    DSTheme(
        isDarkMode = isDarkMode
    ) {
        Column(
            modifier = Modifier.background(DSTheme.colors.backgroundPrimary)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Dark mode", style = DSTheme.typography.bodyMedium, color = DSTheme.colors.textPrimary)
                Spacer(Modifier.width(5.dp))
                Checkbox(
                    checked = isDarkMode,
                    onCheckedChange = { isDarkMode = !isDarkMode }
                )
            }
            DSSkeleton(Modifier.size(100.dp, 50.dp))
        }
    }
}