package com.example.domain.tasks.usecases

import com.example.data.tasks.repos.TaskRepo
import com.example.domain.tasks.entities.Task
import com.example.exception.TaskNotFoundException
import javax.inject.Inject

class GetTaskService
@Inject
constructor(
    private val taskRepo: TaskRepo
){
    fun invoke(taskId: Int): Task {
        return taskRepo.get(taskId) ?: throw TaskNotFoundException()
    }
}