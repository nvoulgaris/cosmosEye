package com.nvoulgaris.cosmoseye.features.apod.data

import com.nvoulgaris.cosmoseye.base.data.apod.ApodDao
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