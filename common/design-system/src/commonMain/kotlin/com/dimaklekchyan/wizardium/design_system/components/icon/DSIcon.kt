package com.dimaklekchyan.wizardium.design_system.components.icon

import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dimaklekchyan.wizardium.design_system.theme.DSTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import wizardium.common.res.generated.resources.Res
import wizardium.common.res.generated.resources.ic_spell

@Composable
fun DSIcon(
    modifier: Modifier = Modifier,
    imageResource: DrawableResource,
    size: DSIconSize = DSIconSize.M,
    color: Color = LocalContentColor.current,
    clickable: Boolean = false,
    indication: Indication? = ripple(),
    onClick: () -> Unit = {}
) {
    Icon(
        modifier = modifier.iconModifier(
            size = size,
            clickable = clickable,
            indication = indication,
            onClick = onClick
        ),
        painter = painterResource(imageResource),
        contentDescription = null,
        tint = color
    )
}

@Composable
fun DSIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    size: DSIconSize = DSIconSize.M,
    color: Color = LocalContentColor.current,
    clickable: Boolean = false,
    indication: Indication? = ripple(),
    onClick: () -> Unit = {}
) {
    Icon(
        modifier = modifier.iconModifier(
            size = size,
            clickable = clickable,
            indication = indication,
            onClick = onClick
        ),
        imageVector = imageVector,
        contentDescription = null,
        tint = color
    )
}

@Composable
private fun Modifier.iconModifier(
    size: DSIconSize,
    clickable: Boolean,
    indication: Indication?,
    onClick: () -> Unit
): Modifier = this
    .size(size.x, size.y)
    .clip(DSTheme.shapes.m)
    .clickable(
        enabled = clickable,
        interactionSource = remember { MutableInteractionSource() },
        indication = indication,
        onClick = onClick
    )

@Stable
enum class DSIconSize(val x: Dp, val y: Dp) {
    XS(12.dp, 12.dp),
    S(16.dp, 16.dp),
    M(20.dp, 20.dp),
    L(24.dp, 24.dp),
    XL(32.dp, 32.dp),
}

@Preview
@Composable
private fun DSIconPreview() {
    DSTheme {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(DSTheme.colors.backgroundPrimary),
        ) {
            DSIcon(
                imageResource = Res.drawable.ic_spell,
                size = DSIconSize.XL
            )
        }
    }
}