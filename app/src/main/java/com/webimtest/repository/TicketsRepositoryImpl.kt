package com.webimtest.repository

import com.webimtest.api.AppApi
import com.webimtest.data.auth.TokenAuthPrefs
import com.webimtest.data.dao.TicketsDao
import com.webimtest.data.dto.toEntity
import com.webimtest.data.error.ApiError
import com.webimtest.data.error.NetworkError
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import java.io.IOException
import javax.inject.Inject

class TicketsRepositoryImpl @Inject constructor(

    private val dao: TicketsDao,
    private val auth: TokenAuthPrefs

) : TicketsRepository {

    private val _stateAuth = MutableSharedFlow<Boolean>()
    override val stateAuth: SharedFlow<Boolean>
        get() = _stateAuth


    override suspend fun authentication(login: String, pass: String) {

        try {
            val response = AppApi.service.authLogin(login, pass)
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val responseAuth = response.body()
                ?: throw ApiError(response.code(), response.message())
            if (responseAuth.result.isNotEmpty()) {
                _stateAuth.emit(false)
            } else {
                _stateAuth.emit(true)
                delay(200)
                responseAuth.token.let { auth.setAuth(it) }

            }
        } catch (e: IOException) {
            throw NetworkError
        }

    }

    override suspend fun getAllTickets() {
        try {
            val response = AppApi.service.getListTickets(auth.getAuthToken())
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }

            val body = response.body()?.data ?: throw ApiError(response.code(), response.message())
            dao.insertTickets(body.toEntity())
        } catch (e: IOException) {
            throw NetworkError
        }
    }
}