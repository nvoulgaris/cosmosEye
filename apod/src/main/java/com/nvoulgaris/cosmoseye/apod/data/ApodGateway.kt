package com.nvoulgaris.cosmoseye.apod.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodGateway {

    @get:GET("planetary/apod")
    val apod: Single<ApodRaw>

    @GET("planetary/apod")
    fun apodBy(@Query("date") date: String): Single<ApodRaw>
}
