package com.example.api.tasks

import com.example.domain.tasks.requests.CreateTaskRequest
import com.example.domain.tasks.usecases.CreateTaskService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.lang.Exception
import javax.inject.Inject

class CreateTaskHttpService
@Inject
constructor(
    private val service: CreateTaskService
){
    suspend fun invoke(call: ApplicationCall) {
        try {
            val request = call.receive<CreateTaskRequest>()
            val response = service.invoke(request)
            call.respond(HttpStatusCode.OK, response)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, e)
        }
    }
}