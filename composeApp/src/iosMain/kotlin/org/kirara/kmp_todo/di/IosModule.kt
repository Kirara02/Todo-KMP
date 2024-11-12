package org.kirara.kmp_todo.di

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.kirara.kmp_todo.Database
import org.kirara.kmp_todo.domain.DispatchersProvider
import org.koin.dsl.module

val iosModule = module {
    single<DispatchersProvider> {
        object : DispatchersProvider {
            override val main: CoroutineDispatcher
                get() = Dispatchers.Main
            override val io: CoroutineDispatcher
                get() = Dispatchers.Default
        }
    }

    single {
        val driver = NativeSqliteDriver(Database.Schema, "todo.db")
        Database(driver)
    }
}