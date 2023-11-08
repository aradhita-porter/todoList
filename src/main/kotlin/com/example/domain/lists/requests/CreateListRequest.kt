package com.example.domain.lists.requests

import kotlinx.serialization.Serializable

@Serializable
data class CreateListRequest (
    val userId: Int,
    val title: String
    )