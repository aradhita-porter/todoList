package com.example.domain.tasks.requests

import com.example.Status

data class UpdateTaskRequest (
    val title: String,
    val description: String,
    val status: Status
)