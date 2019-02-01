package com.nvoulgaris.cosmoseye.features.apod.domain

import com.nvoulgaris.cosmoseye.features.apod.data.ApodRaw
import com.nvoulgaris.cosmoseye.base.data.ApodDb
import io.reactivex.functions.Function
import javax.inject.Inject

class ApodsDbMapper @Inject constructor(
    private val apodDbMapper: ApodDbMapper
) : Function<List<ApodRaw>, List<ApodDb>> {

    override fun apply(apodsRaw: List<ApodRaw>) = apodsRaw.map { apodDbMapper.apply(it) }
}
