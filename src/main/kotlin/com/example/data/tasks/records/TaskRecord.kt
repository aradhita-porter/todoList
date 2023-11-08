package com.example.data.tasks.records

import java.time.Instant

data class TaskRecord(
    val id: Int,
    val data: TaskRecordData,
    val createdAt: Instant,
    val updatedAt: Instant
)