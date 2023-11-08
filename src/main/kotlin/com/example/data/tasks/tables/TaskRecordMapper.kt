package com.example.data.tasks.tables

import com.example.Status
import com.example.data.tasks.records.TaskRecord
import com.example.data.tasks.records.TaskRecordData
import com.example.domain.tasks.entities.Task
import com.example.domain.tasks.requests.CreateTaskRequest
import org.jetbrains.exposed.sql.ResultRow
import javax.inject.Inject

class TaskRecordMapper
@Inject
constructor(){

    fun toRecord(row: ResultRow) = TaskRecord(
        id = row[TaskTable.id].value,
        data = toRecordData(row),
        createdAt = row[TaskTable.created_at],
        updatedAt = row[TaskTable.updated_at]
    )

    private fun toRecordData(row: ResultRow) = TaskRecordData(
        listId = row[TaskTable.listId].toInt(),
        title = row[TaskTable.title],
        description = row[TaskTable.description],
        status = Status.valueOf(row[TaskTable.status])
    )

    fun toRecordData(data: CreateTaskRequest) = TaskRecordData(
        listId = data.listId,
        title = data.title,
        description = data.description,
        status = data.status
    )


    fun fromRecord(record: TaskRecord) = Task(
        id = record.id,
        listId = record.data.listId,
        title = record.data.title,
        description = record.data.description,
        status = record.data.status
    )
}