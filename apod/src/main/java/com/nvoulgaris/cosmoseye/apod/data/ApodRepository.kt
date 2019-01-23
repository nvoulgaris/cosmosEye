package com.nvoulgaris.cosmoseye.apod.data

import com.nvoulgaris.cosmoseye.apod.domain.ApodsDbMapper
import com.nvoulgaris.cosmoseye.base.data.ApodDao
import com.nvoulgaris.cosmoseye.base.data.ApodDb
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ApodRepository @Inject constructor(
    private val dao: ApodDao,
    private val mapper: ApodsDbMapper,
    private val gateway: ApodGateway
) {

    fun dataStream(): Flowable<List<ApodDb>> = dao.dataStream()
        .mergeWith(apod())

    fun pictureBy(date: String): Flowable<List<ApodDb>> = dao.pictureBy(date)
        .mergeWith(apodBy(date))

    private fun apod(): Flowable<List<ApodDb>> = gateway.apod
        .subscribeOn(Schedulers.io())
        .map { apod -> listOf(apod) }
        .map(mapper)
        .doOnSuccess { data ->
            dao.insert(data)
        }
        .doOnError { e ->
            Timber.e(e, "Request failed: ")
        }
        .toFlowable()

    private fun apodBy(date: String): Flowable<List<ApodDb>> = gateway.apodBy(date)
        .subscribeOn(Schedulers.io())
        .map { apod -> listOf(apod) }
        .map(mapper)
        .doOnSuccess { data ->
            dao.insert(data)
        }
        .doOnError { e ->
            Timber.e(e, "Request failed: ")
        }
        .toFlowable()
}
