package com.example

import com.example.di.DaggerHttpComponent
import com.example.routes.list.listRoutes
import com.example.routes.users.usersRoutes
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/todolist",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = ""
    )

    val httpComponent = DaggerHttpComponent.create()

    embeddedServer(Netty, port = 8080, host = "0.0.0.0"){


        install(ContentNegotiation) {
            json()
        }


        routing {
            get ("/" ){
                call.respond(HttpStatusCode.OK)
            }
            route("/user") {
                usersRoutes(httpComponent)
            }
            route("/list") {
                listRoutes(httpComponent)
            }
//            route("/list") { listRoutes() }
//            route("/task") { taskRoutes() }
        }
    }.start(wait = true)
}




