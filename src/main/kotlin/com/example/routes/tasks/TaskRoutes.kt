package com.example.routes.tasks

import com.example.di.HttpComponent
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.taskRoutes(httpComponent: HttpComponent) {

    get("/"){
        httpComponent.getAllTaskHttpService.invoke(call)
    }

    post("/") {
        httpComponent.createTaskHttpService.invoke(call)
    }

    put("/"){
        httpComponent.updateTaskHttpService.invoke(call)
    }

    delete("/") {
        httpComponent.deleteTaskHttpService.invoke(call)
    }
}