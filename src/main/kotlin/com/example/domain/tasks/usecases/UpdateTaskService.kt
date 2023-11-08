package com.example.domain.tasks.usecases

import com.example.data.tasks.repos.TaskRepo
import com.example.domain.tasks.requests.UpdateTaskRequest
import javax.inject.Inject

class UpdateTaskService
@Inject
constructor(
    private val taskRepo: TaskRepo,
    private val getTaskService: GetTaskService
){

    fun invoke(taskId: Int, request: UpdateTaskRequest) {
        val task = getTaskService.invoke(taskId)
        taskRepo.update(taskId, request)
    }
}