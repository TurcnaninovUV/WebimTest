package com.webimtest.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class AuthResponse(
        val name : String = "",
        val token: String = "",
        val result: String = ""
) : Parcelable
