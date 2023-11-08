package com.example.domain.lists.entities

import com.example.domain.tasks.entities.Task
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class TodoList(
    val id: Int,
    val userId: Int,
    val title: String,
    val taskList: List<Task> = emptyList()
    )