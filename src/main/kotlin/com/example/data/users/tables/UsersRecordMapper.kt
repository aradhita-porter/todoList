package com.example.data.users.tables

import com.example.data.users.userRecord.UserRecord
import com.example.data.users.userRecord.UserRecordData
import com.example.domain.users.entities.UserResponse
import com.example.domain.users.requests.CreateUserRequest
import org.jetbrains.exposed.sql.ResultRow
import javax.inject.Inject

class UsersRecordMapper
@Inject
constructor(){

    fun toRecord(row: ResultRow) = UserRecord(
        id = row[UserTable.id].value,
        data = toRecordData(row),
        createdAt = row[UserTable.created_at],
        updatedAt = row[UserTable.updated_at]
    )

    private fun toRecordData(row: ResultRow) = UserRecordData(
        name = row[UserTable.name],
        email = row[UserTable.email],
        phone = row[UserTable.phone],
        passwordHash = row[UserTable.password]
    )

    fun toRecordData(data: CreateUserRequest) = UserRecordData(
        name = data.name,
        email = data.email,
        passwordHash = data.hashedPassword(),
        phone =  data.phone
    )


    fun fromRecord(record: UserRecord) = UserResponse(
        id = record.id
    )
}