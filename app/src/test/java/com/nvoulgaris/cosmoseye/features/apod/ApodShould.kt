package com.nvoulgaris.cosmoseye.features.apod

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.nvoulgaris.cosmoseye.base.data.apod.ApodDao
import com.nvoulgaris.cosmoseye.features.apod.data.ApodGateway
import com.nvoulgaris.cosmoseye.features.apod.data.ApodRaw
import com.nvoulgaris.cosmoseye.features.apod.data.ApodRepository
import com.nvoulgaris.cosmoseye.features.apod.domain.ApodDbMapper
import com.nvoulgaris.cosmoseye.features.apod.domain.ApodInteractor
import com.nvoulgaris.cosmoseye.features.apod.domain.ApodsDbMapper
import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodMapper
import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodViewModel
import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodsMapper
import com.nvoulgaris.cosmoseye.features.infrastructure.BaseTest
import com.nvoulgaris.cosmoseye.features.mocks.MockedApods
import io.reactivex.Flowable
import io.reactivex.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class ApodShould : BaseTest() {

    private val ex = RuntimeException()

    private lateinit var viewModel: ApodViewModel
    private val dao: ApodDao = mock()
    private val gateway: ApodGateway = mock()
    private val apodDbMapper = ApodDbMapper()
    private val dbMapper = ApodsDbMapper(apodDbMapper)
    private val repository = ApodRepository(dao, dbMapper, gateway)
    private val interactor = ApodInteractor(repository)
    private val apodMapper = ApodMapper()
    private val mapper = ApodsMapper(apodMapper)

    private val rawPicture: ApodRaw = MockedApods.apodRaw1
    private val dbPictures = listOf(MockedApods.apodDb2)
    private val picturesFromNetwork = listOf(MockedApods.apod1)
    private val picturesFromDb = listOf(MockedApods.apod2)

    @Before
    fun setup() {
        initMocksBehavior()
    }

    @Test
    fun streamTodaysPictureFromDb() {
        mockGatewayReturnsNoData()

        viewModel = ApodViewModel(interactor, mapper)
        val actualPictures = viewModel.liveData.value

        assertThat(actualPictures).isEqualTo(picturesFromDb)
    }

    @Test
    fun streamTodaysPictureFromNetwork() {
        mockDbReturnsNoData()

        viewModel = ApodViewModel(interactor, mapper)
        val actualPictures = viewModel.liveData.value

        assertThat(actualPictures).isEqualTo(picturesFromNetwork)
    }

    private fun initMocksBehavior() {
        mockDbData()
        mockGatewayData()
    }

    private fun mockDbData() =
        whenever(dao.dataStream()).thenReturn(Flowable.just(dbPictures))

    private fun mockGatewayData() =
        whenever(gateway.apod).thenReturn(Single.just(rawPicture))

    private fun mockDbReturnsNoData() =
        whenever(dao.dataStream()).thenReturn(Flowable.just(listOf()))

    private fun mockGatewayReturnsNoData() =
        whenever(gateway.apod).thenReturn(Single.error(ex))
}
