package com.nvoulgaris.cosmoseye.apod.domain

import com.nvoulgaris.cosmoseye.apod.data.ApodRaw
import io.reactivex.functions.Function
import javax.inject.Inject

class ApodsDbMapper @Inject constructor(
    private val apodDbMapper: ApodDbMapper
) : Function<List<ApodRaw>, List<ApodDb>> {

    override fun apply(apodsRaw: List<ApodRaw>) = apodsRaw.map { apodDbMapper.apply(it) }
}
