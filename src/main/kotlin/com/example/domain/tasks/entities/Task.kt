package com.example.domain.tasks.entities

import com.example.Status
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Task(
    val id: Int,
    val listId: Int,
    val title: String,
    val description: String,
    val status: Status,
    @Contextual val createdAt: Instant,
    @Contextual val updatedAt: Instant
)

