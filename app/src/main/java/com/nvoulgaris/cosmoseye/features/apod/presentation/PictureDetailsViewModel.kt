package com.nvoulgaris.cosmoseye.features.apod.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nvoulgaris.cosmoseye.features.apod.domain.PictureDetailsInteractor
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class PictureDetailsViewModel @Inject constructor(
    private val interactor: PictureDetailsInteractor,
    private val mapper: ApodsMapper,
    date: String
): ViewModel() {

    val liveData: MutableLiveData<List<Apod>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        compositeDisposable.add(bindToInteractor(date))
    }

    private fun bindToInteractor(date: String): Disposable = interactor.dataStream(date)
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
