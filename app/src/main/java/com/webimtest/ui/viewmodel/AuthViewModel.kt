package com.webimtest.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.webimtest.repository.TicketsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: TicketsRepository
) : ViewModel() {

    val stateAuth: LiveData<Boolean> = repository.stateAuth.asLiveData()

    fun authentication(login: String, pass: String) = viewModelScope.launch {
        repository.authentication(login, pass)
    }

}