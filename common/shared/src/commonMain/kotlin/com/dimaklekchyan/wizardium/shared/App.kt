package com.dimaklekchyan.wizardium.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.dimaklekchyan.wizardium.design_system.components.scaffold.DSScaffold
import com.dimaklekchyan.wizardium.design_system.theme.DSTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    DSTheme {
        DSScaffold {
            Text(
                text = "Hello!",
                style = DSTheme.typography.h3,
                color = DSTheme.colors.textPrimary
            )
        }
    }
}