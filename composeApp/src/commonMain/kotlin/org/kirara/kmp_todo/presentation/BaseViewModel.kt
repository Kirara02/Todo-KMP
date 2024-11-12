package org.kirara.kmp_todo.presentation

import kotlinx.coroutines.CoroutineScope

expect abstract class BaseViewModel() {
    protected val scope: CoroutineScope
}