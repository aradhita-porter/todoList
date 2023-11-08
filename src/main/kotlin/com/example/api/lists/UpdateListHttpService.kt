package com.example.api.lists

import com.example.domain.lists.requests.UpdateListRequest
import com.example.domain.lists.usecases.UpdateListService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.util.*
import java.lang.Exception
import javax.inject.Inject

class UpdateListHttpService
@Inject
constructor(
    private val service: UpdateListService
){
    suspend fun invoke(call: ApplicationCall) {
        try {
            val params = call.request.queryParameters
            val listId = params.getOrFail("listId").toInt()
            val request = call.receive<UpdateListRequest>()
            service.invoke(listId, request)
            call.respond(HttpStatusCode.OK)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, e)
        }
    }
}