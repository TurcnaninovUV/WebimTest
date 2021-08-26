package com.webimtest.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.webimtest.data.dao.TicketsDao
import com.webimtest.data.dto.TicketsEntity
import com.webimtest.data.dto.toDto
import com.webimtest.repository.TicketsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TicketsViewModel @Inject constructor(
    private val repository: TicketsRepository,
    private val dao: TicketsDao,
) : ViewModel() {

    val dataTickets = dao.getAllTickets().map(List<TicketsEntity>::toDto)

    init {
        viewModelScope.launch {
            dataTickets.value?.sortedBy { it.cost }
        }
        getListTickets()
    }


    private fun getListTickets() = viewModelScope.launch {
        delay(500)
        repository.getAllTickets()
    }

}