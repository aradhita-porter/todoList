package com.example.domain.tasks.entities

import com.example.Status
import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: Int,
    val listId: Int,
    val title: String,
    val description: String,
    val status: Status
)

