package com.nvoulgaris.cosmoseye.application

import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodViewModelModule
import dagger.Module

@Module(includes = [ApodViewModelModule::class])
class ViewModelModule {
}
