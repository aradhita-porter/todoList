package com.example.domain.lists.usecases

import com.example.data.lists.repos.ListRepo
import javax.inject.Inject

class DeleteListService
@Inject
constructor(
    private val listsRepo: ListRepo,
    private val getListService: GetListService
){

     fun invoke(listId: Int) {
         val list = getListService.invoke(listId)
        return listsRepo.delete(listId)
    }
}