package com.webimtest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TicketsEntity(
    @PrimaryKey(autoGenerate = true)
    val cost: Int,
    val date: String,
    val dest: String,
    val from: String
) {
    fun toDto() = Ticket(cost, date, dest, from)

    companion object {
        fun fromDto(dto: Ticket) =
            TicketsEntity(dto.cost, dto.date, dto.dest, dto.from)
    }
}

fun List<TicketsEntity>.toDto(): List<Ticket> = map(TicketsEntity::toDto)
fun List<Ticket>.toEntity(): List<TicketsEntity> = map(TicketsEntity::fromDto)