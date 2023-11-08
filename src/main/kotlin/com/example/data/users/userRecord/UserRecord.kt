package com.example.data.users.userRecord

import java.time.Instant

data class UserRecord(
    val id: Int,
    val data: UserRecordData,
    val createdAt: Instant,
    val updatedAt: Instant
)