package com.example.data.lists.repos

import com.example.data.lists.tables.ListQueries
import com.example.data.lists.tables.ListRecordMapper
import com.example.domain.lists.requests.CreateListRequest
import javax.inject.Inject
import com.example.domain.lists.entities.TodoList
import com.example.domain.lists.requests.UpdateListRequest

class ListRepo
@Inject
constructor(
    private val queries: ListQueries,
    private val mapper: ListRecordMapper
){
    fun create(request: CreateListRequest): TodoList {
        val recordData = mapper.toRecordData(request)
        val record = queries.create(recordData)
        return mapper.fromRecord(record)
    }

    fun fetch(userId: Int): List<TodoList>  {
        val records = queries.fetch(userId)
        return records.map { mapper.fromRecord(it) }
    }

    fun update (listId: Int, request: UpdateListRequest) {
        queries.update(listId, request)
    }

    fun delete (listId: Int) {
        queries.delete(listId)
    }

    fun get(listId: Int): TodoList? {
        return queries.get(listId)
            ?.let { mapper.toRecord(it) }
            ?.let { mapper.fromRecord(it) }
    }
}