package com.dimaklekchyan.wizardium.design_system.components.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dimaklekchyan.wizardium.design_system.theme.DSTheme
import com.dimaklekchyan.wizardium.design_system.theme.beige10
import com.dimaklekchyan.wizardium.design_system.theme.beige40
import com.dimaklekchyan.wizardium.design_system.theme.beige50
import com.dimaklekchyan.wizardium.design_system.theme.blue20
import com.dimaklekchyan.wizardium.design_system.theme.blue40
import com.dimaklekchyan.wizardium.design_system.theme.blue60
import com.dimaklekchyan.wizardium.design_system.theme.blue90
import com.dimaklekchyan.wizardium.design_system.components.icon.DSIcon
import com.dimaklekchyan.wizardium.design_system.components.icon.DSIconSize
import com.dimaklekchyan.wizardium.design_system.theme.gold20
import com.dimaklekchyan.wizardium.design_system.theme.gold40
import com.dimaklekchyan.wizardium.design_system.theme.gold60
import com.dimaklekchyan.wizardium.design_system.theme.gold90
import com.dimaklekchyan.wizardium.design_system.theme.green20
import com.dimaklekchyan.wizardium.design_system.theme.green40
import com.dimaklekchyan.wizardium.design_system.theme.green60
import com.dimaklekchyan.wizardium.design_system.theme.green90
import com.dimaklekchyan.wizardium.design_system.theme.maroon20
import com.dimaklekchyan.wizardium.design_system.theme.maroon40
import com.dimaklekchyan.wizardium.design_system.theme.maroon60
import com.dimaklekchyan.wizardium.design_system.theme.maroon90
import com.dimaklekchyan.wizardium.design_system.theme.purple20
import com.dimaklekchyan.wizardium.design_system.theme.purple40
import com.dimaklekchyan.wizardium.design_system.theme.purple60
import com.dimaklekchyan.wizardium.design_system.theme.purple90
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import wizardium.common.res.generated.resources.Res
import wizardium.common.res.generated.resources.ic_sorted_hat
import wizardium.common.res.generated.resources.ic_spell

/**
 * Компонент Tag
 *
 * @param text текст компонента
 * @param appearance внешний вид компонента, смотри [DSTagAppearance], по умолчанию [DSTagAppearance.Primary]
 * @param color цвет компонента, смотри [DSTagColor]
 * @param leftIconResource ресурс иконки слева, может быть null
 * @param rightIconResource ресурс иконки справа, может быть null
 * @param onLeftIconClick обработка события клика на левую иконку. Если null, то иконка не кликабельна
 * @param onRightIconClick обработка события клика на правую иконку. Если null, то иконка не кликабельна
 * */
@Composable
fun DSTag(
    modifier: Modifier = Modifier,
    text: String,
    appearance: DSTagAppearance = DSTagAppearance.Primary,
    color: DSTagColor,
    leftIconResource: DrawableResource? = null,
    rightIconResource: DrawableResource? = null,
    onLeftIconClick: (() -> Unit)? = null,
    onRightIconClick: (() -> Unit)? = null,
) {
    val primaryColor = color.primaryColors
    val secondaryColors = color.secondaryColors
    val actualColors by remember(appearance, color) { mutableStateOf(
        if (appearance == DSTagAppearance.Primary) primaryColor else secondaryColors
    ) }
    Row(
        modifier = modifier
            .heightIn(min = 24.dp)
            .clip(DSTheme.shapes.circle)
            .border(width = 1.dp, shape = DSTheme.shapes.circle, color = actualColors.borderColor)
            .background(actualColors.backgroundColor)
            .padding(horizontal = DSTheme.paddings.xs, vertical = DSTheme.paddings.xxs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(DSTheme.paddings.xs)
    ) {
        leftIconResource?.let {
            DSIcon(
                size = DSIconSize.S,
                imageResource = it,
                color = actualColors.contentColor,
                clickable = onLeftIconClick != null,
                onClick = { onLeftIconClick?.let { it() } }
            )
        }

        Text(
            text = text,
            style = DSTheme.typography.body,
            color = actualColors.contentColor
        )

        rightIconResource?.let {
            DSIcon(
                size = DSIconSize.S,
                imageResource = it,
                color = actualColors.contentColor,
                clickable = onRightIconClick != null,
                onClick = { onRightIconClick?.let { it() } }
            )
        }
    }
}

/**
 * Внешний вид компонента [DSTag]
 *
 * @property Primary
 * @property Secondary
 * */
enum class DSTagAppearance {
    Primary,
    Secondary
}

/**
 * Цвет компонента [DSTag], определяет цветовые палитры для primary и secondary вариантов внешнего вида
 * в соответствии с основным цветом
 * */
enum class DSTagColor {
    Beige {
        override val primaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = beige50,
                borderColor = beige50,
                contentColor = DSTheme.colors.textInverseWhite
            )
        override val secondaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = beige10,
                borderColor = beige40,
                contentColor = DSTheme.colors.textInverseBlack
            )
    },
    Green {
        override val primaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = green60,
                borderColor = green60,
                contentColor = green20
            )
        override val secondaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = green90,
                borderColor = green60,
                contentColor = green40
            )
    },
    Gold {
        override val primaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = gold60,
                borderColor = gold60,
                contentColor = gold20
            )
        override val secondaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = gold90,
                borderColor = gold60,
                contentColor = gold40
            )
    },
    Purple {
        override val primaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = purple60,
                borderColor = purple60,
                contentColor = purple20
            )
        override val secondaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = purple90,
                borderColor = purple60,
                contentColor = purple40
            )
    },
    Blue {
        override val primaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = blue60,
                borderColor = blue60,
                contentColor = blue20
            )
        override val secondaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = blue90,
                borderColor = blue60,
                contentColor = blue40
            )
    },
    Maroon {
        override val primaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = maroon60,
                borderColor = maroon60,
                contentColor = maroon20
            )
        override val secondaryColors: DSTagColors
            @Composable get() = DSTagColors(
                backgroundColor = maroon90,
                borderColor = maroon60,
                contentColor = maroon40
            )
    };

    internal abstract val primaryColors: DSTagColors
        @Composable get
    internal abstract val secondaryColors: DSTagColors
        @Composable get
}

@Stable
internal data class DSTagColors(
    val backgroundColor: Color,
    val borderColor: Color,
    val contentColor: Color
)

@Preview
@Composable
private fun DSTagPreview() {
    var isDarkMode by remember { mutableStateOf(false) }
    var showLeftIcon by remember { mutableStateOf(false) }
    var showRightIcon by remember { mutableStateOf(false) }

    DSTheme(
        isDarkMode = isDarkMode
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DSTheme.colors.backgroundPrimary)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Dark mode", color = DSTheme.colors.textPrimary)
                Spacer(Modifier.width(5.dp))
                Checkbox(
                    checked = isDarkMode,
                    onCheckedChange = { isDarkMode = !isDarkMode }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Show left icon", color = DSTheme.colors.textPrimary)
                Spacer(Modifier.width(5.dp))
                Checkbox(
                    checked = showLeftIcon,
                    onCheckedChange = { showLeftIcon = !showLeftIcon }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Show right icon", color = DSTheme.colors.textPrimary)
                Spacer(Modifier.width(5.dp))
                Checkbox(
                    checked = showRightIcon,
                    onCheckedChange = { showRightIcon = !showRightIcon }
                )
            }

            DSTagColor.entries.forEach { color ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    DSTagAppearance.entries.forEach { appearance ->
                        DSTag(
                            text = "Цветной Pill",
                            appearance = appearance,
                            color = color,
                            leftIconResource = if (showLeftIcon) Res.drawable.ic_spell else null,
                            rightIconResource = if (showRightIcon) Res.drawable.ic_sorted_hat else null,
                        )
                    }
                }
            }
        }
    }
}