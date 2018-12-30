package com.nvoulgaris.cosmoseye.apod

import com.nvoulgaris.cosmoseye.apod.mocks.MockedApods
import com.nvoulgaris.cosmoseye.apod.presentation.ApodMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ApodMapperShould {

    private val mapper = ApodMapper()

    private val apodDb1 = MockedApods.apodDb1
    private val apodDb2 = MockedApods.apodDb2
    private val apod1 = MockedApods.apod1
    private val apod2 = MockedApods.apod2

    @Test
    fun mapAListOfApodDbToApod() {
        val apods = mapper.apply(listOf(apodDb1, apodDb2))

        assertThat(apods).containsExactly(apod1, apod2)
    }
}
