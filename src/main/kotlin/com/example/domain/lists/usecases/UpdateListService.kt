package com.example.domain.lists.usecases

import com.example.data.lists.repos.ListRepo
import com.example.domain.lists.requests.UpdateListRequest
import javax.inject.Inject


class UpdateListService
@Inject
constructor(
    private val listsRepo: ListRepo,
    private val getListService: GetListService
){

     fun invoke(listId: Int, request: UpdateListRequest) {
         val list = getListService.invoke(listId)
         listsRepo.update(listId, request)
    }
}