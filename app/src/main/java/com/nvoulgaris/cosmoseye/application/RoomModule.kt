package com.nvoulgaris.cosmoseye.application

import android.content.Context
import com.nvoulgaris.cosmoseye.base.data.CosmosEyeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@Named("appContext") context: Context): CosmosEyeDatabase = CosmosEyeDatabase.getInstance(context)
}
