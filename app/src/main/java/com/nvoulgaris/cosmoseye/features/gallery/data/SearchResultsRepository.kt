package com.nvoulgaris.cosmoseye.features.gallery.data

import com.nvoulgaris.cosmoseye.base.data.gallery.SearchResultDb
import com.nvoulgaris.cosmoseye.base.data.gallery.SearchResultsDao
import com.nvoulgaris.cosmoseye.features.gallery.domain.SearchResultsDbMapper
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class SearchResultsRepository @Inject constructor(
    private val dao: SearchResultsDao,
    private val mapper: SearchResultsDbMapper,
    private val gateway: SearchResultsGateway
){
    fun dataStream(): Flowable<List<SearchResultDb>> = dao.dataStream()
        .mergeWith(search())

    private fun search(): Flowable<List<SearchResultDb>> = gateway.search
        .subscribeOn(Schedulers.io())
        .map(mapper)
        .doOnSuccess { data ->
            dao.insert(data)
        }
        .doOnError { e ->
            Timber.e(e, "Request failed: ")
        }
        .toFlowable()
}
