package com.example.api.lists

import com.example.domain.lists.requests.CreateListRequest
import com.example.domain.lists.usecases.CreateListService
import com.example.exception.TodoException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.lang.Exception
import javax.inject.Inject

class CreateListHttpService
@Inject
constructor(
    private val service: CreateListService
){
    suspend fun invoke(call: ApplicationCall) {
        try {
            val request = call.receive<CreateListRequest>()
            val response = service.invoke(request)
            call.respond(HttpStatusCode.OK, response)
        } catch (e: TodoException){
            call.respond(HttpStatusCode.UnprocessableEntity, e)
        }
        catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, e)
        }
    }
}