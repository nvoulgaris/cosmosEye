package com.nvoulgaris.cosmoseye.application

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient) = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .baseUrl("https://api.nasa.gov/planetary/apod")
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient().newBuilder()
        .build()
}