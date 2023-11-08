package com.example.api.users

import com.example.domain.users.requests.CreateUserRequest
import com.example.domain.users.usecases.CreateUserService
import com.example.exception.TodoException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.lang.Exception
import javax.inject.Inject

class CreateUserHttpService
@Inject
constructor(
    private val service: CreateUserService
){
    suspend fun invoke(call: ApplicationCall) {
        try {
            val request = call.receive<CreateUserRequest>()
            val response = service.invoke(request)
            call.respond(HttpStatusCode.OK, response)
        }
        catch (e: TodoException){
            call.respond(HttpStatusCode.UnprocessableEntity, e)
        }
        catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, e)
        }
    }
}
