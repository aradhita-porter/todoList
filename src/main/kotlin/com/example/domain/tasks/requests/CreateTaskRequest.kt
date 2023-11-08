package com.example.domain.tasks.requests

import com.example.Status


data class CreateTaskRequest (
    val listId: Int,
    val title: String,
    val description: String,
    val status: Status
    )