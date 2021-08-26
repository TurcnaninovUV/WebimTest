package com.webimtest.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.webimtest.data.dto.TicketsEntity


@Dao
interface TicketsDao {

    @Query("SELECT * FROM TicketsEntity")
    fun getAllTickets(): LiveData<List<TicketsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTickets(field: List<TicketsEntity>)

}