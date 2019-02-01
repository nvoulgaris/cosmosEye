package com.nvoulgaris.cosmoseye.features.gallery.domain

import com.nvoulgaris.cosmoseye.base.data.gallery.SearchResultDb
import com.nvoulgaris.cosmoseye.features.gallery.data.SearchResultsRaw
import io.reactivex.functions.Function
import javax.inject.Inject

class SearchResultsDbMapper @Inject constructor(
    private val searchResultDbMapper: SearchResultDbMapper
) : Function<List<SearchResultsRaw>, List<SearchResultDb>> {

    override fun apply(searchResultsRaw: List<SearchResultsRaw>) = searchResultsRaw.map { searchResultDbMapper.apply(it) }
}
