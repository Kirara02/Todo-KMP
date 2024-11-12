package org.kirara.kmp_todo.presentation.todo.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.kirara.kmp_todo.domain.model.TodoEntity
import org.kirara.kmp_todo.domain.model.TodoRole
import org.kirara.kmp_todo.domain.model.TodoSection

@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.todoSection(
    section: TodoSection,
    onClick: (TodoEntity) -> Unit,
    onDelete: (TodoEntity) -> Unit
) {
    if (section.todos.isEmpty()) return

    // Header
    if (!section.header.isNullOrEmpty()) {
        item(
            key = section.header
        ) {
            Text(
                modifier = Modifier
                    .animateItemPlacement()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 8.dp),
                text = section.header,
                color = Color.White,
                style = MaterialTheme.typography.h6
            )
        }
    }

    // Todos
    items(
        items = section.todos,
        key = { it.id }
    ) { todo ->
        TodoItem(
            todo = todo,
            role = section.todosWithRoles.getOrElse(todo) { TodoRole.MIDDLE },
            onClick = { onClick(todo) },
            onDelete = { onDelete(todo) }
        )
    }
}