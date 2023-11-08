package com.example.domain.lists.usecases

import com.example.data.lists.repos.ListRepo
import com.example.domain.lists.entities.TodoList
import com.example.domain.users.usecases.GetUserService
import javax.inject.Inject

class GetAllListsService
@Inject
constructor(
    private val listsRepo: ListRepo,
    private val getUserService: GetUserService
){

    fun invoke(userId: Int): List<TodoList> {
        val user = getUserService.invoke(userId)
        return listsRepo.fetch(userId)
    }
}