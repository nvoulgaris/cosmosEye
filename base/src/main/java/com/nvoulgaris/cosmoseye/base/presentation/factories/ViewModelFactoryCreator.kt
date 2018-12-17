package com.nvoulgaris.cosmoseye.base.presentation.factories

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelFactoryCreator @Inject constructor() {

    fun <T : Any> createFor(viewModel: T): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(viewModel::class.java)) {
                    return viewModel as T
                }

                throw IllegalArgumentException("Could not create a ViewModel for unknown class $modelClass")
            }
        }
    }
}
