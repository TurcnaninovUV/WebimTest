package com.webimtest.data.auth

interface TokenAuthPrefs {
    fun setAuth(token: String)
    fun getAuthToken() : String
}