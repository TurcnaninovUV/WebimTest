package com.webimtest.di

import com.webimtest.data.auth.TokenAuthPrefs
import com.webimtest.data.auth.TokenAuthPrefsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class TokenAuthPrefsModule {

    @Binds
    @Singleton
    abstract fun bindTokenAuthPrefsModule(impl: TokenAuthPrefsImpl): TokenAuthPrefs
}