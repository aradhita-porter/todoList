package com.example.domain.tasks.requests

import com.example.Status
import kotlinx.serialization.Serializable

@Serializable
data class CreateTaskRequest (
    val listId: Int,
    val title: String,
    val description: String,
    var status: Status = Status.TODO
    )