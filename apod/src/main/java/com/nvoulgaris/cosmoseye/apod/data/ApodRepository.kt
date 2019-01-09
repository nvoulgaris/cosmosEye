package com.nvoulgaris.cosmoseye.apod.data

import com.nvoulgaris.cosmoseye.apod.domain.ApodDb
import com.nvoulgaris.cosmoseye.apod.domain.ApodDbMapper
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ApodRepository @Inject constructor(
    private val apodGateway: ApodGateway,
    private val mapper: ApodDbMapper
) {

    fun apod(): Flowable<ApodDb> = apodGateway.apod
        .subscribeOn(Schedulers.io())
        .map(mapper)
        .doOnSuccess { data ->
            Timber.e("Data received: $data")
        }
        .doOnError { e ->
            Timber.e(e, "Request failed: ")
        }
        .toFlowable()
}
