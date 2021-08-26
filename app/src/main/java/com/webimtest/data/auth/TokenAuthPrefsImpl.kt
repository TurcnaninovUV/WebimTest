package com.webimtest.data.auth

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenAuthPrefsImpl @Inject constructor(
        @ApplicationContext private val context: Context
) : TokenAuthPrefs {
    private val prefs = context.getSharedPreferences("auth", Context.MODE_PRIVATE)
    private val tokenKey = "token"

    override fun setAuth(token: String) {
        with(prefs.edit()) {
            putString(tokenKey, token)
            apply()
        }
    }

    override fun getAuthToken(): String {
        return prefs.getString(tokenKey, null)!!
    }
}