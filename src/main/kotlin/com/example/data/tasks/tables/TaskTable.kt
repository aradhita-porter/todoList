package com.example.data.tasks.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.Instant

object TaskTable : IntIdTable("task") {
    val listId =  integer("listId")
    val title = varchar("title", 256)
    val description = varchar("description", 256)
    val status = varchar("status", 256)
    val created_at = timestamp("created_at").default(Instant.now())
    val updated_at = timestamp("updated_at").default(Instant.now())
}