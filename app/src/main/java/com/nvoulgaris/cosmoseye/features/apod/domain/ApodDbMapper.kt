package com.nvoulgaris.cosmoseye.features.apod.domain

import com.nvoulgaris.cosmoseye.features.apod.data.ApodRaw
import com.nvoulgaris.cosmoseye.base.data.ApodDb
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
