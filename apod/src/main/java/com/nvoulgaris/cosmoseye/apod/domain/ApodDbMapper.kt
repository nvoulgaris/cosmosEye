package com.nvoulgaris.cosmoseye.apod.domain

import com.nvoulgaris.cosmoseye.apod.data.ApodRaw
import io.reactivex.functions.Function
import javax.inject.Inject

class ApodDbMapper @Inject constructor() : Function<List<ApodRaw>, List<ApodDb>> {

    override fun apply(apodsRaw: List<ApodRaw>) = apodsRaw.map { toDb(it) }

    private fun toDb(apodRaw: ApodRaw) = ApodDb(
        apodRaw.copyright,
        apodRaw.date,
        apodRaw.explanation,
        apodRaw.hdurl,
        apodRaw.mediaType,
        apodRaw.serviceVersion,
        apodRaw.title,
        apodRaw.url
    )
}
