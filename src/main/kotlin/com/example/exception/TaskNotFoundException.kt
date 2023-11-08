package com.example.exception

import kotlinx.serialization.Serializable

@Serializable
class TaskNotFoundException() : TodoException("task with given id does not exist")