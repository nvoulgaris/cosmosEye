package com.nvoulgaris.cosmoseye.features.apod.presentation

import com.nvoulgaris.cosmoseye.base.data.ApodDb
import io.reactivex.functions.Function
import javax.inject.Inject

class ApodMapper @Inject constructor() : Function<ApodDb, Apod> {

    override fun apply(apodDb: ApodDb): Apod = Apod(
        apodDb.copyright,
        apodDb.date,
        apodDb.explanation,
        apodDb.hdUrl,
        apodDb.mediaType,
        apodDb.serviceVersion,
        apodDb.title,
        apodDb.url
    )
}
