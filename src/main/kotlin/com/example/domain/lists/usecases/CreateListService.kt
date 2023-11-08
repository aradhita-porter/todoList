package com.example.domain.lists.usecases

import com.example.data.lists.repos.ListRepo
import com.example.domain.lists.requests.CreateListRequest
import com.example.domain.lists.entities.TodoList
import com.example.domain.users.usecases.GetUserService
import javax.inject.Inject

class CreateListService
@Inject
constructor(
    private val listsRepo: ListRepo,
    private val getUserService: GetUserService
){

    fun invoke(request: CreateListRequest): TodoList {
        val user = getUserService.invoke(request.userId)
        return listsRepo.create(request)
    }
}