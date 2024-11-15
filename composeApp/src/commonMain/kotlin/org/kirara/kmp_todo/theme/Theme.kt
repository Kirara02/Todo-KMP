package org.kirara.kmp_todo.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkColorScheme = darkColors(
    primary = Dark500,
    secondary = Dark200
)

@Composable
fun TodoTheme(
    content: @Composable () -> Unit
) {
    PlatformColors(
        statusBarColor = darkColorScheme.primary,
        navBarColor = Color.Black
    )
    MaterialTheme(colors = darkColorScheme) {
        content()
    }
}