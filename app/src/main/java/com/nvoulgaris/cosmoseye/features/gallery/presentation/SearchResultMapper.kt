package com.nvoulgaris.cosmoseye.features.gallery.presentation

import com.nvoulgaris.cosmoseye.base.data.gallery.SearchResultDb
import io.reactivex.functions.Function
import javax.inject.Inject

class SearchResultMapper @Inject constructor() : Function<SearchResultDb, SearchResult> {

    override fun apply(searchResultDb: SearchResultDb): SearchResult =
        SearchResult(
            searchResultDb.id
        )
}
