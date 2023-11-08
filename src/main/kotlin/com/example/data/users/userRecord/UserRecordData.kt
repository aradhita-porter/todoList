package com.example.data.users.userRecord

import kotlinx.serialization.Serializable

@Serializable
data class UserRecordData (
    val name: String,
    val email: String,
    val phone: String,
    val passwordHash: String
)