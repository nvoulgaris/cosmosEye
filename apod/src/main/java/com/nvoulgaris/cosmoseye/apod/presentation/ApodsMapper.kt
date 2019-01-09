package com.nvoulgaris.cosmoseye.apod.presentation

import com.nvoulgaris.cosmoseye.apod.domain.ApodDb
import io.reactivex.functions.Function
import javax.inject.Inject

class ApodsMapper @Inject constructor(
    private val apodMapper: ApodMapper
) : Function<List<ApodDb>, List<Apod>> {

    override fun apply(apodsDb: List<ApodDb>) = apodsDb.map { apodMapper.apply(it) }
}
