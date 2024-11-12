package org.kirara.kmp_todo.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.kirara.kmp_todo.Database
import org.kirara.kmp_todo.domain.DispatchersProvider
import org.koin.dsl.module

val desktopModule = module {

    single<DispatchersProvider> {
        object : DispatchersProvider {
            override val main: CoroutineDispatcher
                get() = Dispatchers.Main
            override val io: CoroutineDispatcher
                get() = Dispatchers.IO
        }
    }

    single<Database> {
        val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        Database.Schema.create(driver)
        Database(driver)
    }
}