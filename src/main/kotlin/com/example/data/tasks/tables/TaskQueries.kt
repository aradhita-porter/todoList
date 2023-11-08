package com.example.data.tasks.tables

import com.example.data.tasks.records.TaskRecord
import com.example.data.tasks.records.TaskRecordData
import com.example.domain.tasks.requests.UpdateTaskRequest
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.Instant
import javax.inject.Inject


class TaskQueries
@Inject
constructor(
    private val resultRowMapper: TaskRecordMapper
){

    fun create(data: TaskRecordData): TaskRecord = transaction {
        TaskTable.insert {
            it[listId] = data.listId
            it[title] = data.title
            it[description] = data.description
            it[status] = data.status.toString()
            it[created_at] = Instant.now()
            it[updated_at] = Instant.now()
        }.resultedValues
            ?.first()
            .let { resultRowMapper.toRecord(it!!) }

    }

    fun fetch(listId: Int): List<TaskRecord> = transaction {
        TaskTable.select { TaskTable.listId eq listId}
            .toList()
            .map { resultRowMapper.toRecord(it) }
    }

    fun update(taskId: Int, request: UpdateTaskRequest) {
        transaction {
            TaskTable.update(where = { TaskTable.id eq taskId }) {
                it[status] = request.status.toString()
                it[updated_at] = Instant.now()
            }
        }
    }

    fun delete(taskId: Int) {
        transaction {
            TaskTable.deleteWhere { TaskTable.id eq taskId }
        }
    }


    fun get(taskId: Int): ResultRow? = transaction{
        TaskTable.select { TaskTable.id eq taskId }.singleOrNull()
    }
}