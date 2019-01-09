package com.nvoulgaris.cosmoseye.apod.presentation

import com.nvoulgaris.cosmoseye.apod.domain.ApodDb
import io.reactivex.functions.Function
import javax.inject.Inject

class ApodMapper @Inject constructor() : Function<ApodDb, Apod> {

    override fun apply(apodDb: ApodDb): Apod = Apod(
        apodDb.copyright,
        apodDb.date,
        apodDb.explanation,
        apodDb.hdurl,
        apodDb.mediaType,
        apodDb.serviceVersion,
        apodDb.title,
        apodDb.url
    )
}
