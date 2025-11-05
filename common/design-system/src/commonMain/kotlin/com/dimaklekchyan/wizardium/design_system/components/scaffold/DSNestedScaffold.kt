package com.dimaklekchyan.wizardium.design_system.components.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.dimaklekchyan.wizardium.design_system.theme.DSTheme
import com.dimaklekchyan.wizardium.design_system.components.icon.DSIcon
import com.dimaklekchyan.wizardium.design_system.components.icon.DSIconSize
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DSNestedScaffold(
    modifier: Modifier = Modifier,
    title: String,
    backgroundColor: Color = DSTheme.colors.backgroundPrimary,
    headerColor: Color = backgroundColor,
    contentColor: Color = DSTheme.colors.textPrimary,
    backButtonEnabled: Boolean = true,
    headerElevated: Boolean = true,
    onBackClick: () -> Unit,
    actions: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    DSScaffold(
        modifier = modifier,
        backgroundColor = backgroundColor,
        bottomBar = bottomBar,
        content = content,
        topBar = {
            DSTobBar(
                title = title,
                headerColor = headerColor,
                elevated = headerElevated,
                contentColor = contentColor,
                backButtonEnabled = backButtonEnabled,
                actions = actions,
                onBackClick = onBackClick
            )
        }
    )
}

private enum class DSTobBarLayoutElements {
    BackButton,
    Title,
    Actions
}
@Composable
internal fun DSTobBar(
    modifier: Modifier = Modifier,
    title: String,
    headerColor: Color = DSTheme.colors.backgroundPrimary,
    contentColor: Color = DSTheme.colors.textPrimary,
    backButtonEnabled: Boolean = true,
    elevated: Boolean = true,
    actions: @Composable () -> Unit = {},
    onBackClick: () -> Unit,
) {
    val shadowModifier = if (elevated) {
        Modifier.dropShadow(
            shape = RoundedCornerShape(0.dp),
            shadow = Shadow(
                radius = 1.dp,
                offset = DpOffset(0.dp, 1.dp)
            )
        )
    } else {
        Modifier
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .then(shadowModifier)
            .background(headerColor)
            .statusBarsPadding()
            .padding(
                horizontal = DSTheme.paddings.m,
                vertical = DSTheme.paddings.s
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Layout(
            modifier = Modifier,
            content = {
                DSIcon(
                    modifier = Modifier
                        .layoutId(DSTobBarLayoutElements.BackButton)
                        .padding(end = DSTheme.paddings.m),
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    size = DSIconSize.M,
                    onClick = onBackClick,
                    color = contentColor,
                    clickable = backButtonEnabled
                )
                Text(
                    modifier = Modifier.layoutId(DSTobBarLayoutElements.Title),
                    text = title,
                    maxLines = 1,
                    style = DSTheme.typography.h3,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    color = contentColor
                )
                Box(
                    modifier = Modifier
                        .layoutId(DSTobBarLayoutElements.Actions)
                        .padding(start = DSTheme.paddings.m)
                ) {
                    actions()
                }
            },
            measurePolicy = layoutMeasurePolicy()
        )
    }
}

private fun layoutMeasurePolicy(
): MeasureScope.(measurables: List<Measurable>, constraints: Constraints) -> MeasureResult {
    return { measurables, constraints ->
        val backButtonPlaceable = measurables
            .first { it.layoutId == DSTobBarLayoutElements.BackButton }
            .measure(constraints)
        val actionsPlaceable = measurables
            .first { it.layoutId == DSTobBarLayoutElements.Actions }
            .measure(constraints)
        val availableWidthForTitle = (constraints.maxWidth - (maxOf(backButtonPlaceable.width, actionsPlaceable.width) * 2)).coerceAtLeast(0)
        val titlePlaceable = measurables
            .first { it.layoutId == DSTobBarLayoutElements.Title }
            .measure(constraints.copy(maxWidth = availableWidthForTitle))

        val backHeight = backButtonPlaceable.height
        val titleHeight = titlePlaceable.height
        val actionsHeight = actionsPlaceable.height
        val height = maxOf(maxOf(backHeight, titleHeight), actionsHeight)

        layout(constraints.maxWidth, height) {
            backButtonPlaceable.place(0, (height / 2 - backHeight / 2).coerceAtLeast(0))
            actionsPlaceable.place((constraints.maxWidth - actionsPlaceable.width), (height / 2 - actionsHeight / 2).coerceAtLeast(0))
            titlePlaceable.place((constraints.maxWidth / 2 - titlePlaceable.width / 2).coerceAtLeast(0), (height / 2 - titleHeight / 2).coerceAtLeast(0))
        }
    }
}

@Preview
@Composable
private fun NestedScaffoldPreview() {
    var isDarkMode by remember { mutableStateOf(false) }
    var headerElevated by remember { mutableStateOf(false) }

    DSTheme(
        isDarkMode = isDarkMode
    ) {
        DSNestedScaffold(
            modifier = Modifier.fillMaxSize(),
            title = "Title",
            headerElevated = headerElevated,
            onBackClick = {}
        ) {
            Button(
                onClick = { headerElevated = !headerElevated }
            ) {
                Text("Change elevation")
            }
        }
    }
}