package com.nvoulgaris.cosmoseye.apod.data

import com.nvoulgaris.cosmoseye.apod.domain.ApodDb
import com.nvoulgaris.cosmoseye.apod.domain.ApodDbMapper
import io.reactivex.Flowable
import javax.inject.Inject

class ApodRepository @Inject constructor(
//    private val apodGateway: ApodGateway,
    private val mapper: ApodDbMapper
) {

    fun apod(): Flowable<List<ApodDb>> = Flowable.empty()
//    fun apod(): Flowable<List<ApodDb>> = apodGateway.apod
//        .subscribeOn(Schedulers.io())
//        .map(mapper)
//        .doOnSuccess {  }
//        .doOnError {  }
//        .toFlowable()
}
