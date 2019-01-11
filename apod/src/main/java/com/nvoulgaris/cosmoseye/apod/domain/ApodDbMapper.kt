package com.nvoulgaris.cosmoseye.apod.domain

import com.nvoulgaris.cosmoseye.apod.data.ApodRaw
import com.nvoulgaris.cosmoseye.base.data.ApodDb
import io.reactivex.functions.Function
import javax.inject.Inject

class ApodDbMapper @Inject constructor() : Function<ApodRaw, ApodDb> {

    override fun apply(apodRaw: ApodRaw): ApodDb = ApodDb(
        copyright = apodRaw.copyright,
        date = apodRaw.date,
        explanation = apodRaw.explanation,
        hdUrl = apodRaw.hdUrl,
        mediaType = apodRaw.mediaType,
        serviceVersion = apodRaw.serviceVersion,
        title = apodRaw.title,
        url = apodRaw.url
    )
}
