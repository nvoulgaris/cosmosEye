package com.nvoulgaris.cosmoseye.features.apod

import com.nvoulgaris.cosmoseye.features.apod.domain.ApodDbMapper
import com.nvoulgaris.cosmoseye.features.apod.domain.ApodsDbMapper
import com.nvoulgaris.cosmoseye.features.apod.mocks.MockedApods
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ApodsDbMapperShould {

    private val apodDbMapper = ApodDbMapper()
    private val mapper = ApodsDbMapper(apodDbMapper)

    private val apodRaw1 = MockedApods.apodRaw1
    private val apodRaw2 = MockedApods.apodRaw2
    private val apodDb1 = MockedApods.apodDb1
    private val apodDb2 = MockedApods.apodDb2

    @Test
    fun mapRawValuesToDbValues() {
        val apodsDb = mapper.apply(listOf(apodRaw1, apodRaw2))

        assertThat(apodsDb).containsExactly(apodDb1, apodDb2)
    }
}
