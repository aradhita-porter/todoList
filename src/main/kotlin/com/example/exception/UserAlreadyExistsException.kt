package com.example.exception

import kotlinx.serialization.Serializable

@Serializable
class UserAlreadyExistsException: TodoException("User already exists for the email and phone number")