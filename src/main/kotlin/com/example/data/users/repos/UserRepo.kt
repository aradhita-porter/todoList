package com.example.data.users.repos

import com.example.data.users.tables.UserQueries
import com.example.data.users.tables.UsersRecordMapper
import com.example.domain.users.entities.UserResponse

import com.example.domain.users.requests.CreateUserRequest
import javax.inject.Inject

class UserRepo
@Inject
constructor(
    private val queries: UserQueries,
    private val mapper: UsersRecordMapper
){
    fun create(request: CreateUserRequest): UserResponse {
        val recordData = mapper.toRecordData(request)
        val record = queries.create(recordData)
        return mapper.fromRecord(record)
    }

    fun get(userId: Int): UserResponse? {
        return queries.get(userId)
            ?.let { mapper.toRecord(it) }
            ?.let { mapper.fromRecord(it) }
    }
}