package com.webimtest.api

import com.webimtest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val BASE_URL = "http://drsoak.pythonanywhere.com/"


val logging = HttpLoggingInterceptor().apply {
    if (BuildConfig.DEBUG) {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

val okhttp = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okhttp)
    .build()


interface ApiService {

    @GET("auth")
    suspend fun authLogin(
        @Query("login") login: String,
        @Query("password") pass: String
    ): Response<AuthResponse>

    @GET("get")
    suspend fun getListTickets(@Query("token") token: String): Response<TicketsResponse>
}


object AppApi {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}