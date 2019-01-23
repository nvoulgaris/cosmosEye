package com.nvoulgaris.cosmoseye.apod.domain

import com.nvoulgaris.cosmoseye.apod.data.ApodRepository
import com.nvoulgaris.cosmoseye.base.data.ApodDb
import io.reactivex.Flowable
import javax.inject.Inject

class PictureDetailsInteractor @Inject constructor(private val repository: ApodRepository) {

    fun dataStream(date: String): Flowable<List<ApodDb>> = repository.pictureBy(date)
}
