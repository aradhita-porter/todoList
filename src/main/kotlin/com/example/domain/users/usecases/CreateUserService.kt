package com.example.domain.users.usecases

import com.example.data.users.repos.UserRepo
import com.example.domain.users.entities.UserResponse
import com.example.domain.users.requests.CreateUserRequest
import com.example.exception.TodoException
import javax.inject.Inject

class CreateUserService
@Inject
constructor(
    private val usersRepo: UserRepo
){
   fun invoke(request: CreateUserRequest): UserResponse {
       try {
           return usersRepo.create(request)
       } catch (e: TodoException) {
           throw e
       }
   }

}