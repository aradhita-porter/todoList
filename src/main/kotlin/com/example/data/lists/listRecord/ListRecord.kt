package com.example.data.lists.listRecord

import java.time.Instant

data class ListRecord(
    val id: Int,
    val data: ListRecordData,
    val createdAt: Instant,
    val updatedAt: Instant
)