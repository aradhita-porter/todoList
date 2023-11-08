package com.example.data.users.tables

import com.example.data.users.userRecord.UserRecord
import com.example.data.users.userRecord.UserRecordData
import com.example.exception.UserAlreadyExistsException
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.Instant
import javax.inject.Inject

class UserQueries
@Inject
constructor(
    private val resultRowMapper: UsersRecordMapper
){
    fun create(data: UserRecordData): UserRecord = transaction {
        try {
            UserTable.insert {
                it[name] = data.name
                it[email] = data.email
                it[phone] = data.phone
                it[password] = data.passwordHash
                it[created_at] = Instant.now()
                it[updated_at] = Instant.now()
            }.resultedValues
                ?.first()
                .let { resultRowMapper.toRecord(it!!) }
        } catch (e: ExposedSQLException) {
            throw toDomainException(e)
        }
    }

    fun get(userId: Int): ResultRow? = transaction{
        UserTable.select { UserTable.id eq userId }.singleOrNull()
    }


    private fun toDomainException(e: ExposedSQLException): Exception = when {
        e.message?.contains("unique_user_idx") == true -> UserAlreadyExistsException()
        else -> e
    }
}