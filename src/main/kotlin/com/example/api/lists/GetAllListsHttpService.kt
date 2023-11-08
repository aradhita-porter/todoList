package com.example.api.lists

import com.example.domain.lists.usecases.GetAllListsService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.util.*
import java.lang.Exception
import javax.inject.Inject

class GetAllListsHttpService
@Inject
constructor(
    private val service: GetAllListsService
){
    suspend fun invoke(call: ApplicationCall) {
        try {
            val params = call.request.queryParameters
            val userId = params.getOrFail("userId").toInt()
            val response = service.invoke(userId)
            call.respond(HttpStatusCode.OK, response)
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, e)
        }
    }
}