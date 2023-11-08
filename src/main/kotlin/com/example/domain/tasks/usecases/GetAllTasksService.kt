package com.example.domain.tasks.usecases

import com.example.data.tasks.repos.TaskRepo
import com.example.domain.lists.usecases.GetListService
import com.example.domain.tasks.entities.Task
import javax.inject.Inject


class GetAllTasksService
@Inject
constructor(
    private val tasksRepo: TaskRepo,
    private val getListService: GetListService
){

    fun invoke(listId: Int): List<Task> {
        val list = getListService.invoke(listId)
        return tasksRepo.fetch(listId)
    }
}