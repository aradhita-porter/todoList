package com.example.domain.tasks.usecases

import com.example.data.tasks.repos.TaskRepo
import javax.inject.Inject

class DeleteTaskService
@Inject
constructor(
    private val tasksRepo: TaskRepo,
    private val getTaskService: GetTaskService
){

    fun invoke(taskId: Int) {
        val task = getTaskService.invoke(taskId)
        return tasksRepo.delete(taskId)
    }
}