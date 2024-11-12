package org.kirara.kmp_todo

import org.kirara.kmp_todo.di.commonModule
import org.kirara.kmp_todo.di.iosModule
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(commonModule, iosModule)
    }
}