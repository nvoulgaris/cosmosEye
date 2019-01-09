package com.nvoulgaris.cosmoseye.apod.data

import io.reactivex.Single
import retrofit2.http.GET

interface ApodGateway {

    @get:GET("planetary/apod")
    val apod: Single<ApodRaw>
}