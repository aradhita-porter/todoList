package com.example.exception

import kotlinx.serialization.Serializable

@Serializable
class UserNotFoundException() : TodoException("User with given id does not exist")