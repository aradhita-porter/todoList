package com.example.api.tasks

import com.example.domain.lists.usecases.DeleteListService
import com.example.domain.tasks.usecases.DeleteTaskService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.util.*
import java.lang.Exception
import javax.inject.Inject

class DeleteTaskHttpService
@Inject
constructor(
    private val service: DeleteTaskService
){
    suspend fun invoke(call: ApplicationCall) {
        try {
            val params = call.request.queryParameters
            val taskId = params.getOrFail("taskId").toInt()
            service.invoke(taskId)
            call.respond(HttpStatusCode.OK)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, e)
        }
    }
}