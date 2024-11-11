package org.kirara.kmp_todo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPToDo",
    ) {
        App()
    }
}