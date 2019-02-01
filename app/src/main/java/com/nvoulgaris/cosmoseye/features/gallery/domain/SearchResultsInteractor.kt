package com.nvoulgaris.cosmoseye.features.gallery.domain

import com.nvoulgaris.cosmoseye.base.data.gallery.SearchResultDb
import com.nvoulgaris.cosmoseye.features.gallery.data.SearchResultsRepository
import io.reactivex.Flowable
import javax.inject.Inject

class SearchResultsInteractor @Inject constructor(
    private val repository: SearchResultsRepository
) {

    fun dataStream(): Flowable<List<SearchResultDb>> = repository.dataStream()
}
