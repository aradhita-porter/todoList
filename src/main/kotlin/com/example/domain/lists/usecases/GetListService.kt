package com.example.domain.lists.usecases

import com.example.data.lists.repos.ListRepo
import com.example.domain.lists.entities.TodoList
import com.example.exception.ListNotFoundException
import javax.inject.Inject


class GetListService
@Inject
constructor(
    private val listRepo: ListRepo
){
    fun invoke(listId: Int): TodoList {
        return listRepo.get(listId) ?: throw ListNotFoundException()
    }
}