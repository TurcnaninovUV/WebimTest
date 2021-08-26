package com.webimtest.api


import com.webimtest.data.dto.Ticket

data class TicketsResponse(
        val data: List<Ticket>,
        val result: String,
        val timestamp: Long
)