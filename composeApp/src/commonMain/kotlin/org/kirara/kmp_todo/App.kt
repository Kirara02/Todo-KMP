package org.kirara.kmp_todo


import androidx.compose.runtime.*
import org.kirara.kmp_todo.presentation.todo.compose.TodoScreen
import org.kirara.kmp_todo.theme.TodoTheme
import org.koin.compose.KoinContext

@Composable
fun App() {
    KoinContext{
        TodoTheme {
            TodoScreen()
        }
    }
}