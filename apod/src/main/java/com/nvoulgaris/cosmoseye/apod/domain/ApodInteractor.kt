package com.nvoulgaris.cosmoseye.apod.domain

import com.nvoulgaris.cosmoseye.apod.data.ApodRepository
import com.nvoulgaris.cosmoseye.base.data.ApodDb
import io.reactivex.Flowable
import javax.inject.Inject

class ApodInteractor @Inject constructor(private val repository: ApodRepository) {

    fun dataStream(): Flowable<ApodDb> = repository.apod()
}
