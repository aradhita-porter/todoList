package com.example.domain.users.usecases

import com.example.data.users.repos.UserRepo
import com.example.domain.users.entities.UserResponse
import com.example.exception.UserNotFoundException
import javax.inject.Inject

class GetUserService
@Inject
constructor(
    private val usersRepo: UserRepo
){
    fun invoke(userId: Int): UserResponse {
        return usersRepo.get(userId) ?: throw UserNotFoundException()
    }
}