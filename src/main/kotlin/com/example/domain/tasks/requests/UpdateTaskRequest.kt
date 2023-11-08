package com.example.domain.tasks.requests

import com.example.Status
import kotlinx.serialization.Serializable

@Serializable
data class UpdateTaskRequest (
    val status: Status
)