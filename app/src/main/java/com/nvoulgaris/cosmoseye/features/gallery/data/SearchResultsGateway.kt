package com.nvoulgaris.cosmoseye.features.gallery.data

import io.reactivex.Single

interface SearchResultsGateway {

    val search: Single<List<SearchResultsRaw>>
}
