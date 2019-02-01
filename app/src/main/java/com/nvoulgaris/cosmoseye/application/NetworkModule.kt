package com.nvoulgaris.cosmoseye.application

import com.nvoulgaris.cosmoseye.features.apod.data.ApodGateway
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    private val BASE_URL = "https://api.nasa.gov/"

    @Provides
    @Singleton
    fun provideApodGateway(retrofit: Retrofit): ApodGateway {
        return retrofit.create(ApodGateway::class.java)
    }

    @Provides
    @Singleton
    fun providesMoshi() =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        apiKeyInterceptor: ApiKeyInterceptor
    ): OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(apiKeyInterceptor)
        .build()
}
