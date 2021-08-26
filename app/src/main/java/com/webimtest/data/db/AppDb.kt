package com.webimtest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.webimtest.data.dao.TicketsDao
import com.webimtest.data.dto.TicketsEntity

@Database(entities = [TicketsEntity::class], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun ticketsDao(): TicketsDao
}