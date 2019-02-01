package com.nvoulgaris.cosmoseye.features.gallery.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nvoulgaris.cosmoseye.features.gallery.domain.SearchResultsInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class SearchResultsViewModel @Inject constructor(
    private val interactor: SearchResultsInteractor,
    private val mapper: SearchResultsMapper
) : ViewModel() {

    val liveData: MutableLiveData<List<SearchResult>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        compositeDisposable.add(bindToInteractor())
    }

    private fun bindToInteractor(): Disposable = interactor.dataStream()
        .subscribeOn(Schedulers.io())
        .map(mapper)
        .subscribe(
            { value ->
                liveData.postValue(value)
            }
            ,
            { e ->
                Timber.v("Failed to retrieve data : ${e.message}")
            }
        )
}
