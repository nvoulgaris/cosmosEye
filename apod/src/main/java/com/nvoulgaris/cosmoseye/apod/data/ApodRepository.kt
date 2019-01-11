package com.nvoulgaris.cosmoseye.apod.data

import com.nvoulgaris.cosmoseye.apod.domain.ApodDbMapper
import com.nvoulgaris.cosmoseye.base.data.ApodDao
import com.nvoulgaris.cosmoseye.base.data.ApodDb
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ApodRepository @Inject constructor(
    private val dao: ApodDao,
    private val mapper: ApodDbMapper,
    private val gateway: ApodGateway
) {

    fun apod(): Flowable<ApodDb> = gateway.apod
        .subscribeOn(Schedulers.io())
        .map(mapper)
        .doOnSuccess { data ->
            Timber.e("Data received: $data")
            dao.insert(data)
        }
        .doOnError { e ->
            Timber.e(e, "Request failed: ")
        }
        .toFlowable()
}
