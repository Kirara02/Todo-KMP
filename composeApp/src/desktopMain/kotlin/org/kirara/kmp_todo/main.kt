package org.kirara.kmp_todo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.kirara.kmp_todo.di.commonModule
import org.kirara.kmp_todo.di.desktopModule
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(commonModule, desktopModule)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPToDo",
    ) {
        App()
    }
}