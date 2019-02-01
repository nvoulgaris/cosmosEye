package com.nvoulgaris.cosmoseye.features.gallery

import com.nvoulgaris.cosmoseye.features.gallery.presentation.SearchResultMapper
import com.nvoulgaris.cosmoseye.features.gallery.presentation.SearchResultsMapper
import com.nvoulgaris.cosmoseye.features.mocks.MockedSearchResults
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SearchResultsMapperShould {

    private val searchResultMapper = SearchResultMapper()
    private val mapper = SearchResultsMapper(searchResultMapper)

    private val searchResultDb1 = MockedSearchResults.searchResultDb1
    private val searchResultDb2 = MockedSearchResults.searchResultDb2
    private val searchResult1 = MockedSearchResults.searchResult1
    private val searchResult2 = MockedSearchResults.searchResult2

    @Test
    fun mapAListOfSearchResultsDbToSearchResults() {
        val searchResults = mapper.apply(listOf(searchResultDb1, searchResultDb2))

        assertThat(searchResults).containsExactly(searchResult1, searchResult2)
    }
}
