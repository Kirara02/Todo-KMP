package org.kirara.kmp_todo.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
expect fun PlatformColors(
    statusBarColor: Color,
    navBarColor: Color
)