package org.kirara.kmp_todo.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.kirara.kmp_todo.Database
import org.kirara.kmp_todo.domain.DispatchersProvider
import org.kirara.kmp_todo.domain.TodoRepository
import org.kirara.kmp_todo.domain.model.TodoEntity
import org.kirara.kmptodo.Todo

class SqlDelightTodoRepository(
    database: Database,
    private val dispatchersProvider: DispatchersProvider
) : TodoRepository {
    private val todoQueries = database.todoQueries

    override suspend fun getTodos(): Flow<List<TodoEntity>> = todoQueries
        .selectAll()
        .asFlow()
        .mapToList(dispatchersProvider.io)
        .map { list ->
            list.map { it.toTodoEntity() }
        }

    override suspend fun addTodo(todo: TodoEntity) {
        todoQueries.insert(todo.toTodo())
    }

    override suspend fun updateTodo(todo: TodoEntity) {
        todoQueries.update(todo.toTodo())
    }

    override suspend fun deleteTodo(todo: TodoEntity) {
        todoQueries.delete(todo.id)
    }
}


private fun Todo.toTodoEntity() = TodoEntity(
    id = id,
    title = title,
    subtitle = subtitle,
    done = done ?: false
)

private fun TodoEntity.toTodo() = Todo(
    id = id,
    title = title,
    subtitle = subtitle,
    done = done
)