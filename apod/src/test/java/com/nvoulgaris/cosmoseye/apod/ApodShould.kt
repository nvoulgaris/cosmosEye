package com.nvoulgaris.cosmoseye.apod

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.nvoulgaris.cosmoseye.apod.data.ApodGateway
import com.nvoulgaris.cosmoseye.apod.data.ApodRaw
import com.nvoulgaris.cosmoseye.apod.data.ApodRepository
import com.nvoulgaris.cosmoseye.apod.domain.ApodDbMapper
import com.nvoulgaris.cosmoseye.apod.domain.ApodInteractor
import com.nvoulgaris.cosmoseye.apod.domain.ApodsDbMapper
import com.nvoulgaris.cosmoseye.apod.infrastructure.RxMockSchedulersRule
import com.nvoulgaris.cosmoseye.apod.mocks.MockedApods
import com.nvoulgaris.cosmoseye.apod.presentation.ApodMapper
import com.nvoulgaris.cosmoseye.apod.presentation.ApodViewModel
import com.nvoulgaris.cosmoseye.apod.presentation.ApodsMapper
import com.nvoulgaris.cosmoseye.base.data.ApodDao
import io.reactivex.Flowable
import io.reactivex.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ApodShould {

    @Rule
    @JvmField
    val immediateSchedulerRule = RxMockSchedulersRule()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    private val ex = RuntimeException()

    private val dao: ApodDao = mock()
    private val gateway: ApodGateway = mock()
    private val apodDbMapper = ApodDbMapper()
    private val dbMapper = ApodsDbMapper(apodDbMapper)
    private val repository = ApodRepository(dao, dbMapper, gateway)
    private val interactor = ApodInteractor(repository)
    private val apodMapper = ApodMapper()
    private val mapper = ApodsMapper(apodMapper)
    private lateinit var viewModel: ApodViewModel

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
