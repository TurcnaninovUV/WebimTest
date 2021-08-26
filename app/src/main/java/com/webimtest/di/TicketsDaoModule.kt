package com.webimtest.di

import com.webimtest.data.dao.TicketsDao
import com.webimtest.data.db.AppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class TicketsDaoModule {
    @Provides
    fun provideFieldsDao(db: AppDb): TicketsDao = db.ticketsDao()
}