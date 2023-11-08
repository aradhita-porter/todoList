package com.example.routes.users

import com.example.di.HttpComponent
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.usersRoutes(httpComponent: HttpComponent) {

    post("") {httpComponent.createUserHttpService.invoke(call)}
}