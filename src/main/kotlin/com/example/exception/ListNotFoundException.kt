package com.example.exception

import kotlinx.serialization.Serializable

@Serializable
class ListNotFoundException() : TodoException("List with given id does not exist")