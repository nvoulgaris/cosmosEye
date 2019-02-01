package com.nvoulgaris.cosmoseye.features.mocks

import com.nvoulgaris.cosmoseye.base.data.gallery.SearchResultDb
import com.nvoulgaris.cosmoseye.features.gallery.data.SearchResultsRaw
import com.nvoulgaris.cosmoseye.features.gallery.presentation.SearchResult

class MockedSearchResults {

    companion object {

        val searchResultRaw1 = SearchResultsRaw("1")
        val searchResultRaw2 = SearchResultsRaw("2")
        val searchResultDb1 = SearchResultDb("1")
        val searchResultDb2 = SearchResultDb("2")
        val searchResult1 = SearchResult("1")
        val searchResult2 = SearchResult("2")
    }
}
