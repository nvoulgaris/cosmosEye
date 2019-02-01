package com.nvoulgaris.cosmoseye.features.apod.presentation

import com.nvoulgaris.cosmoseye.base.data.apod.ApodDb
import io.reactivex.functions.Function
import javax.inject.Inject

class ApodsMapper @Inject constructor(
    private val apodMapper: ApodMapper
) : Function<List<ApodDb>, List<Apod>> {

    override fun apply(apodsDb: List<ApodDb>) = apodsDb.map { apodMapper.apply(it) }
}
