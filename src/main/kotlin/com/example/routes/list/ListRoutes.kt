package com.example.routes.list

import com.example.di.HttpComponent
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.listRoutes(httpComponent: HttpComponent) {

    get(""){
        httpComponent.getAllListsHttpService.invoke(call)
    }

    post("") {
        httpComponent.createListHttpService.invoke(call)
    }

    put(""){
        httpComponent.updateListHttpService.invoke(call)
    }

    delete("") {
        httpComponent.deleteListHttpService.invoke(call)
    }
}