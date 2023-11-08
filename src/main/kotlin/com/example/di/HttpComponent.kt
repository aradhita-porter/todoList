package com.example.di

import com.example.api.lists.CreateListHttpService
import com.example.api.lists.DeleteListHttpService
import com.example.api.lists.GetAllListsHttpService
import com.example.api.lists.UpdateListHttpService
import com.example.api.tasks.CreateTaskHttpService
import com.example.api.tasks.DeleteTaskHttpService
import com.example.api.tasks.GetTasksHttpService
import com.example.api.tasks.UpdateTaskHttpService
import com.example.api.users.CreateUserHttpService
import dagger.Component;

@Component
interface HttpComponent {

    // Users
    val createUserHttpService: CreateUserHttpService

    // Lists
    val createListHttpService: CreateListHttpService
    val getAllListsHttpService: GetAllListsHttpService
    val deleteListHttpService: DeleteListHttpService
    val updateListHttpService: UpdateListHttpService

    // Tasks
    val createTaskHttpService: CreateTaskHttpService
    val getAllTaskHttpService: GetTasksHttpService
    val updateTaskHttpService: UpdateTaskHttpService
    val deleteTaskHttpService: DeleteTaskHttpService
}