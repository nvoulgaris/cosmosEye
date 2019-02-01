package com.nvoulgaris.cosmoseye.features.gallery.presentation

import com.nvoulgaris.cosmoseye.base.data.gallery.SearchResultDb
import io.reactivex.functions.Function
import javax.inject.Inject

class SearchResultsMapper @Inject constructor(
    private val searchResultMapper: SearchResultMapper
) : Function<List<SearchResultDb>, List<SearchResult>> {

    override fun apply(searchResultDb: List<SearchResultDb>) = searchResultDb.map { searchResultMapper.apply(it) }
}
