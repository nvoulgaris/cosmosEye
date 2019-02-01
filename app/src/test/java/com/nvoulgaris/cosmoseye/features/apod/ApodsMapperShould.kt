package com.nvoulgaris.cosmoseye.features.apod

import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodMapper
import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodsMapper
import com.nvoulgaris.cosmoseye.features.mocks.MockedApods
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ApodsMapperShould {

    private val apodMapper = ApodMapper()
    private val mapper = ApodsMapper(apodMapper)

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
