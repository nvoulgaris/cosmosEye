package com.nvoulgaris.cosmoseye.apod.domain

import com.nvoulgaris.cosmoseye.apod.data.ApodRaw
import io.reactivex.functions.Function
import javax.inject.Inject

class ApodDbMapper @Inject constructor() : Function<ApodRaw, ApodDb> {

    override fun apply(apodRaw: ApodRaw): ApodDb = ApodDb(
        apodRaw.copyright,
        apodRaw.date,
        apodRaw.explanation,
        apodRaw.hdUrl,
        apodRaw.mediaType,
        apodRaw.serviceVersion,
        apodRaw.title,
        apodRaw.url
    )
}
