package com.dimaklekchyan.wizardium.design_system.components.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dimaklekchyan.wizardium.design_system.theme.DSTheme

@Composable
fun DSScaffold(
    modifier: Modifier = Modifier,
    backgroundColor: Color = DSTheme.colors.backgroundPrimary,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier
            .background(backgroundColor),
        topBar = topBar,
        bottomBar = bottomBar,
        containerColor = backgroundColor,
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .consumeWindowInsets(innerPadding)
                    .padding(innerPadding)
                    .navigationBarsPadding(),
            ) {
                content()
            }
        }
    )
}