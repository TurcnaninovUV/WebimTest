package com.webimtest.repository

import kotlinx.coroutines.flow.SharedFlow

interface TicketsRepository {

    val stateAuth: SharedFlow<Boolean>

    suspend fun getAllTickets()

    suspend fun authentication(login: String, pass: String)

}