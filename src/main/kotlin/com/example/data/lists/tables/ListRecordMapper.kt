package com.example.data.lists.tables

import com.example.data.lists.listRecord.ListRecord
import com.example.data.lists.listRecord.ListRecordData

import com.example.domain.lists.requests.CreateListRequest
import com.example.domain.lists.entities.TodoList
import org.jetbrains.exposed.sql.ResultRow
import javax.inject.Inject

class ListRecordMapper
@Inject
constructor(){

    fun toRecord(row: ResultRow) = ListRecord(
        id = row[ListTable.id].value,
        data = toRecordData(row),
        createdAt = row[ListTable.created_at],
        updatedAt = row[ListTable.updated_at]
    )

    private fun toRecordData(row: ResultRow) = ListRecordData(
        userId = row[ListTable.userId].toInt(),
        title = row[ListTable.title]
    )

    fun toRecordData(data: CreateListRequest) = ListRecordData(
        userId = data.userId,
        title = data.title
    )


    fun fromRecord(record: ListRecord) = TodoList(
        id = record.id,
        userId = record.data.userId,
        title = record.data.title
    )
}