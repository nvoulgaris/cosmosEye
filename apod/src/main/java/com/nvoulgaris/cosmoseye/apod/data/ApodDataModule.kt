package com.nvoulgaris.cosmoseye.apod.data

import com.nvoulgaris.cosmoseye.base.data.ApodDao
import com.nvoulgaris.cosmoseye.base.data.CosmosEyeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApodDataModule {

    @Provides
    @Singleton
    fun provideApodDao(database: CosmosEyeDatabase): ApodDao = database.apodDao()
}