package com.example.api.lists;

import com.example.domain.lists.usecases.DeleteListService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.util.*
import java.lang.Exception
import javax.inject.Inject


class DeleteListHttpService
@Inject
constructor(
    private val service: DeleteListService
){
    suspend fun invoke(call: ApplicationCall) {
        try {
            val params = call.request.queryParameters
            val listId = params.getOrFail("listId").toInt()
            service.invoke(listId)
            call.respond(HttpStatusCode.OK)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, e)
        }
    }
}