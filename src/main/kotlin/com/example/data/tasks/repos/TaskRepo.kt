package com.example.data.tasks.repos

import com.example.data.tasks.tables.TaskQueries
import com.example.data.tasks.tables.TaskRecordMapper
import com.example.domain.lists.entities.TodoList
import javax.inject.Inject
import com.example.domain.tasks.entities.Task
import com.example.domain.tasks.requests.CreateTaskRequest
import com.example.domain.tasks.requests.UpdateTaskRequest

class TaskRepo
@Inject
constructor(
    private val queries: TaskQueries,
    private val mapper: TaskRecordMapper
){
    fun create(request: CreateTaskRequest): Task {
        val recordData = mapper.toRecordData(request)
        val record = queries.create(recordData)
        return mapper.fromRecord(record)
    }

    fun fetch(listId: Int): List<Task>  {
        val records = queries.fetch(listId)
        return records.map { mapper.fromRecord(it) }
    }

    fun update (taskId: Int, request: UpdateTaskRequest) {
        queries.update(taskId, request)
    }

    fun delete (taskId: Int) {
        queries.delete(taskId)
    }

    fun get(taskId: Int): Task? {
        return queries.get(taskId)
            ?.let { mapper.toRecord(it) }
            ?.let { mapper.fromRecord(it) }
    }
}