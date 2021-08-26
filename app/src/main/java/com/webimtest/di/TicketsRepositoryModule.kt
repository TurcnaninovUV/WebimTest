package com.webimtest.di

import com.webimtest.repository.TicketsRepository
import com.webimtest.repository.TicketsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class TicketsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTicketsRepository(impl: TicketsRepositoryImpl): TicketsRepository
}
