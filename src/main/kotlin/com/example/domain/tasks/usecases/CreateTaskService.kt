package com.example.domain.tasks.usecases

import com.example.data.tasks.repos.TaskRepo
import com.example.domain.lists.usecases.GetListService
import com.example.domain.tasks.entities.Task
import com.example.domain.tasks.requests.CreateTaskRequest
import javax.inject.Inject

class CreateTaskService
@Inject
constructor(
    private val taskRepo: TaskRepo,
    private val getListService: GetListService
){

    fun invoke(request: CreateTaskRequest): Task {
        val list = getListService.invoke(request.listId)
        return taskRepo.create(request)
    }
}