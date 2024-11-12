package org.kirara.kmp_todo.di

import org.kirara.kmp_todo.data.InMemoryTodoRepository
import org.kirara.kmp_todo.data.SqlDelightTodoRepository
import org.kirara.kmp_todo.domain.TodoRepository
import org.kirara.kmp_todo.presentation.todo.TodoViewModel
import org.koin.dsl.module

val commonModule = module {

    single<TodoRepository> {
        SqlDelightTodoRepository(
            database = get(),
            dispatchersProvider = get()
        )
//        InMemoryTodoRepository()
    }

    viewModelDefinition {
        TodoViewModel(
            dispatchers = get(),
            repository = get()
        )
    }
}