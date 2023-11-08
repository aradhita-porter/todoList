package com.example.domain.users.requests

import kotlinx.serialization.Serializable
import org.mindrot.jbcrypt.BCrypt

@Serializable
data class CreateUserRequest(
    val name: String,
    val email: String,
    val phone: String,
    val password: String
){
    fun hashedPassword(): String{
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }
}
