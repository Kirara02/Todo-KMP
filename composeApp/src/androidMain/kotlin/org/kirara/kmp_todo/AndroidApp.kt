package org.kirara.kmp_todo

import android.app.Application
import org.kirara.kmp_todo.di.androidModule
import org.kirara.kmp_todo.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AndroidApp)
            modules(commonModule, androidModule)
        }
    }
}