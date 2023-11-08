package com.example.data.tasks.records

import com.example.Status

data class TaskRecordData (
    val listId: Int,
    val title: String,
    val description: String,
    val status: Status
)