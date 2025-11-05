package com.dimaklekchyan.wizardium.design_system.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.dimaklekchyan.wizardium.design_system.theme.DSTheme

/**
 * Карточка с контентом
 * @param elevated если true, то имеет тень
 * @param shape форма блока и тени
 * @param content основной контент
 * */
@Composable
fun DSCard(
    modifier: Modifier = Modifier,
    elevated: Boolean = false,
    appearance: DSCardAppearance = DSCardAppearance.Primary,
    content: @Composable () -> Unit,
) {
    val shadowModifier = if (elevated) {
        Modifier.dropShadow(
            shape = DSTheme.shapes.xl,
            shadow = Shadow(
                radius = 1.dp,
                offset = DpOffset(0.dp, 1.dp)
            )
        )
    } else {
        Modifier
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .then(shadowModifier)
            .clip(DSTheme.shapes.xl)
            .border(width = 1.dp, color = appearance.borderColor, shape = DSTheme.shapes.xl)
            .background(appearance.backgroundColor)
            .padding(DSTheme.paddings.l),
        verticalArrangement = Arrangement.spacedBy(DSTheme.paddings.m)
    ) {
        content()
    }
}

enum class DSCardAppearance {
    Primary {
        override val backgroundColor: Color
            @Composable get() = DSTheme.colors.backgroundPrimary
        override val borderColor: Color
            @Composable get() = DSTheme.colors.border
        override val titleColor: Color
            @Composable get() = DSTheme.colors.textPrimary
    },
    Secondary {
        override val backgroundColor: Color
            @Composable get() = DSTheme.colors.backgroundSecondary
        override val borderColor: Color
            @Composable get() = DSTheme.colors.border
        override val titleColor: Color
            @Composable get() = DSTheme.colors.textSecondary
    };

    abstract val backgroundColor: Color
        @Composable get
    abstract val borderColor: Color
        @Composable get
    abstract val titleColor: Color
        @Composable get
}