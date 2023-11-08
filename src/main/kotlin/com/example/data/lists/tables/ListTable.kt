package com.example.data.lists.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.Instant

object ListTable : IntIdTable("list") {
    val userId =  integer("userId")
    val title = varchar("title", 256)
    val created_at = timestamp("created_at").default(Instant.now())
    val updated_at = timestamp("updated_at").default(Instant.now())
}