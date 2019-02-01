package com.nvoulgaris.cosmoseye.features.apod

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.nvoulgaris.cosmoseye.features.apod.data.ApodGateway
import com.nvoulgaris.cosmoseye.features.apod.data.ApodRaw
import com.nvoulgaris.cosmoseye.features.apod.data.ApodRepository
import com.nvoulgaris.cosmoseye.features.apod.domain.ApodDbMapper
import com.nvoulgaris.cosmoseye.features.apod.domain.ApodsDbMapper
import com.nvoulgaris.cosmoseye.features.apod.domain.PictureDetailsInteractor
import com.nvoulgaris.cosmoseye.features.infrastructure.RxMockSchedulersRule
import com.nvoulgaris.cosmoseye.features.mocks.MockedApods
import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodMapper
import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodsMapper
import com.nvoulgaris.cosmoseye.features.apod.presentation.PictureDetailsViewModel
import com.nvoulgaris.cosmoseye.base.data.apod.ApodDao
import io.reactivex.Flowable
import io.reactivex.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class PictureDetailsShould {

    @Rule
    @JvmField
    val immediateSchedulerRule = RxMockSchedulersRule()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    companion object {
        private const val DATE = "2018-12-21"
    }

    private val ex = RuntimeException()

    private val dao: ApodDao = mock()
    private val gateway: ApodGateway = mock()
    private val apodDbMapper = ApodDbMapper()
    private val dbMapper = ApodsDbMapper(apodDbMapper)
    private val repository = ApodRepository(dao, dbMapper, gateway)
    private val interactor = PictureDetailsInteractor(repository)
    private val apodMapper = ApodMapper()
    private val mapper = ApodsMapper(apodMapper)

    private val rawPicture: ApodRaw = MockedApods.apodRaw1
    private val dbPictures = listOf(MockedApods.apodDb2)
    private val pictureFromNetwork = MockedApods.apod1
    private val pictureFromDb = MockedApods.apod2
    private val picturesFromNetwork = listOf(pictureFromNetwork)
    private val picturesFromDb = listOf(pictureFromDb)

    @Before
    fun setup() {
        initMocksBehavior()
    }

    @Test
    fun streamPictureFromDb() {
        mockGatewayReturnsNoData()

        val viewModel = PictureDetailsViewModel(interactor, mapper,
            DATE
        )
        val actualPicture = viewModel.liveData.value

        assertThat(actualPicture).isEqualTo(picturesFromDb)
    }

    @Test
    fun streamPictureFromNetwork() {
        mockDbReturnsNoData()

        val viewModel = PictureDetailsViewModel(interactor, mapper,
            DATE
        )
        val actualPicture = viewModel.liveData.value

        assertThat(actualPicture).isEqualTo(picturesFromNetwork)
    }

    private fun initMocksBehavior() {
        mockDbData()
        mockGatewayData()
    }

    private fun mockDbData() =
        whenever(dao.pictureBy(DATE)).thenReturn(Flowable.just(dbPictures))

    private fun mockGatewayData() =
        whenever(gateway.apodBy(DATE)).thenReturn(Single.just(rawPicture))

    private fun mockDbReturnsNoData() =
        whenever(dao.pictureBy(DATE)).thenReturn(Flowable.just(listOf()))

    private fun mockGatewayReturnsNoData() =
        whenever(gateway.apodBy(DATE)).thenReturn(Single.error(ex))
}
