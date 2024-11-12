package org.kirara.kmp_todo.domain

import kotlinx.coroutines.flow.Flow
import org.kirara.kmp_todo.domain.model.TodoEntity

interface TodoRepository {
    suspend fun getTodos(): Flow<List<TodoEntity>>
    suspend fun addTodo(todo: TodoEntity)
    suspend fun updateTodo(todo: TodoEntity)
    suspend fun deleteTodo(todo: TodoEntity)
}