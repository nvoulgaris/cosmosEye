package com.nvoulgaris.cosmoseye.features.gallery

import com.nvoulgaris.cosmoseye.features.gallery.domain.SearchResultDbMapper
import com.nvoulgaris.cosmoseye.features.gallery.domain.SearchResultsDbMapper
import com.nvoulgaris.cosmoseye.features.mocks.MockedSearchResults
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SearchResultsDbMapperShould {

    private val searchResultDbMapper = SearchResultDbMapper()
    private val mapper = SearchResultsDbMapper(searchResultDbMapper)

    private val searchResultRaw1 = MockedSearchResults.searchResultRaw1
    private val searchResultRaw2 = MockedSearchResults.searchResultRaw2
    private val searchResultDb1 = MockedSearchResults.searchResultDb1
    private val searchResultDb2 = MockedSearchResults.searchResultDb2

    @Test
    fun mapRawValuesToDbValues() {
        val searchResultsDb = mapper.apply(listOf(searchResultRaw1, searchResultRaw2))

        assertThat(searchResultsDb).containsExactly(searchResultDb1, searchResultDb2)
    }
}
