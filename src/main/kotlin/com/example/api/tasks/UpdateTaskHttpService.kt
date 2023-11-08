package com.example.api.tasks

import com.example.domain.lists.requests.UpdateListRequest
import com.example.domain.lists.usecases.UpdateListService
import com.example.domain.tasks.requests.UpdateTaskRequest
import com.example.domain.tasks.usecases.UpdateTaskService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.util.*
import java.lang.Exception
import javax.inject.Inject

class UpdateTaskHttpService
@Inject
constructor(
    private val service: UpdateTaskService
){
    suspend fun invoke(call: ApplicationCall) {
        try {
            val params = call.request.queryParameters
            val taskId = params.getOrFail("taskId").toInt()
            val request = call.receive<UpdateTaskRequest>()
            service.invoke(taskId, request)
            call.respond(HttpStatusCode.OK)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, e)
        }
    }
}