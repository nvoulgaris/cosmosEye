package com.nvoulgaris.cosmoseye.features.gallery.domain

import com.nvoulgaris.cosmoseye.base.data.gallery.SearchResultDb
import com.nvoulgaris.cosmoseye.features.gallery.data.SearchResultsRaw
import io.reactivex.functions.Function
import javax.inject.Inject

class SearchResultDbMapper @Inject constructor() : Function<SearchResultsRaw, SearchResultDb> {

    override fun apply(searchResultsRaw: SearchResultsRaw): SearchResultDb =
        SearchResultDb(
            searchResultsRaw.id
        )
}
