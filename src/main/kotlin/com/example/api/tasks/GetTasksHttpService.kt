package com.example.api.tasks

import com.example.domain.tasks.usecases.GetAllTasksService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.util.*
import java.lang.Exception
import javax.inject.Inject

class GetTasksHttpService
@Inject
constructor(
    private val service: GetAllTasksService
){
    suspend fun invoke(call: ApplicationCall) {
        try {
            val params = call.request.queryParameters
            val listId = params.getOrFail("listId").toInt()
            val response = service.invoke(listId)
            call.respond(HttpStatusCode.OK, response)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, e)
        }
    }
}