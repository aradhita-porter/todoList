package com.example.data.users.tables

import org.jetbrains.exposed.sql.javatime.timestamp
import org.jetbrains.exposed.dao.id.IntIdTable
import java.time.Instant

object UserTable : IntIdTable("user") {

    val name = varchar("name", 256)
    val email = varchar("email", 256)
    val phone = varchar("phone_number", 256)
    val password = varchar("password_hash", 256)
    val created_at = timestamp("created_at").default(Instant.now())
    val updated_at = timestamp("updated_at").default(Instant.now())
}