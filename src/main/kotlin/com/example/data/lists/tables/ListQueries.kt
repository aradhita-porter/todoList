package com.example.data.lists.tables

import com.example.data.lists.listRecord.ListRecord
import com.example.data.lists.listRecord.ListRecordData
import com.example.domain.lists.requests.UpdateListRequest
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.Instant
import javax.inject.Inject


class ListQueries
@Inject
constructor(
    private val resultRowMapper: ListRecordMapper
){

     fun create(data: ListRecordData): ListRecord = transaction {
        ListTable.insert {
            it[userId] = data.userId
            it[title] = data.title
            it[created_at] = Instant.now()
            it[updated_at] = Instant.now()
        }.resultedValues
            ?.first()
            .let { resultRowMapper.toRecord(it!!) }

    }

     fun fetch(userId: Int): List<ListRecord> = transaction {
        ListTable.select { ListTable.userId eq userId}
            .toList()
            .map { resultRowMapper.toRecord(it) }
    }

     fun update(listId: Int, request: UpdateListRequest) {
        transaction {
            ListTable.update(where = { ListTable.id eq listId }) {
                it[title] = request.title
                it[updated_at] = Instant.now()
            }
        }
    }

    fun delete(listId: Int) {
        transaction {
            ListTable.deleteWhere { ListTable.id eq listId }
        }
    }

    fun get(listId: Int): ResultRow? = transaction{
        ListTable.select { ListTable.id eq listId }.singleOrNull()
    }
}