package com.example.domain.lists.entities

import com.example.domain.tasks.entities.Task
import kotlinx.serialization.Serializable

@Serializable
data class TodoList(
    val id: Int,
    val userId: Int,
    val title: String,
    val taskList: List<Task> = emptyList()
    )