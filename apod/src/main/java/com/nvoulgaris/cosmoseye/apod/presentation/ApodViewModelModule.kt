package com.nvoulgaris.cosmoseye.apod.presentation

import android.arch.lifecycle.ViewModelProvider
import com.nvoulgaris.cosmoseye.base.presentation.factories.ViewModelFactoryCreator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApodViewModelModule {

    @Provides
    @Singleton
    fun provideViewModelProviderFactory(viewModelFactoryCreator: ViewModelFactoryCreator, viewModel: ApodViewModel): ViewModelProvider.Factory {
        return viewModelFactoryCreator.createFor(viewModel)
    }
}
