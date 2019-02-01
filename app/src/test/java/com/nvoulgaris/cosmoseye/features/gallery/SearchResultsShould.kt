package com.nvoulgaris.cosmoseye.features.gallery

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.nvoulgaris.cosmoseye.base.data.gallery.SearchResultsDao
import com.nvoulgaris.cosmoseye.features.gallery.data.SearchResultsGateway
import com.nvoulgaris.cosmoseye.features.gallery.data.SearchResultsRepository
import com.nvoulgaris.cosmoseye.features.gallery.domain.SearchResultDbMapper
import com.nvoulgaris.cosmoseye.features.gallery.domain.SearchResultsDbMapper
import com.nvoulgaris.cosmoseye.features.gallery.domain.SearchResultsInteractor
import com.nvoulgaris.cosmoseye.features.gallery.presentation.SearchResultMapper
import com.nvoulgaris.cosmoseye.features.gallery.presentation.SearchResultsMapper
import com.nvoulgaris.cosmoseye.features.gallery.presentation.SearchResultsViewModel
import com.nvoulgaris.cosmoseye.features.infrastructure.BaseTest
import com.nvoulgaris.cosmoseye.features.mocks.MockedSearchResults
import io.reactivex.Flowable
import io.reactivex.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class SearchResultsShould : BaseTest() {

    private val ex = RuntimeException()

    private lateinit var viewModel: SearchResultsViewModel
    private val dao: SearchResultsDao = mock()
    private val gateway: SearchResultsGateway = mock()
    private val searchResultDbMapper = SearchResultDbMapper()
    private val searchResultsDbMapper = SearchResultsDbMapper(searchResultDbMapper)
    private val repository = SearchResultsRepository(dao, searchResultsDbMapper, gateway)
    private val interactor = SearchResultsInteractor(repository)
    private val searchResultMapper = SearchResultMapper()
    private val mapper = SearchResultsMapper(searchResultMapper)

    private val rawResult = MockedSearchResults.searchResultRaw1
    private val dbResults = listOf(MockedSearchResults.searchResultDb2)
    private val resultsFromNetwork = listOf(MockedSearchResults.searchResult1)
    private val resultsFromDb = listOf(MockedSearchResults.searchResult2)

    @Before
    fun setup() {
        initMocksBehavior()
    }

    @Test
    fun streamSearchResultsBasedOnQueryFromDb() {
        mockGatewayReturnsNoData()

        viewModel = SearchResultsViewModel(interactor, mapper)
        val actualResults = viewModel.liveData.value

        assertThat(actualResults).isEqualTo(resultsFromDb)
    }

    @Test
    fun streamSearchResultsBasedOnQueryFromNetwork() {
        mockDbReturnsNoData()

        viewModel = SearchResultsViewModel(interactor, mapper)
        val actualResults = viewModel.liveData.value

        assertThat(actualResults).isEqualTo(resultsFromNetwork)
    }

    private fun initMocksBehavior() {
        mockDbData()
        mockGatewayData()
    }

    private fun mockDbData() =
        whenever(dao.dataStream()).thenReturn(Flowable.just(dbResults))

    private fun mockGatewayData() =
        whenever(gateway.search).thenReturn(Single.just(listOf(rawResult)))

    private fun mockDbReturnsNoData() =
        whenever(dao.dataStream()).thenReturn(Flowable.just(listOf()))

    private fun mockGatewayReturnsNoData() =
        whenever(gateway.search).thenReturn(Single.error(ex))
}
