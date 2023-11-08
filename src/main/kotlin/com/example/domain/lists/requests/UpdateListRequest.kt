package com.example.domain.lists.requests

import kotlinx.serialization.Serializable

@Serializable
data class UpdateListRequest (
    val title: String
)