package com.nvoulgaris.cosmoseye.apod.data

import io.reactivex.Single
import javax.inject.Inject

class MockApodGateway @Inject constructor() : ApodGateway {

    override val apod: Single<List<ApodRaw>>
        get() = Single.just(listOf())
}
