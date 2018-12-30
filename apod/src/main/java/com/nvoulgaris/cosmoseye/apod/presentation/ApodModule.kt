package com.nvoulgaris.cosmoseye.apod.presentation

import com.nvoulgaris.cosmoseye.apod.data.ApodGateway
import com.nvoulgaris.cosmoseye.apod.data.ApodRepository
import com.nvoulgaris.cosmoseye.apod.data.MockApodGateway
import com.nvoulgaris.cosmoseye.apod.domain.ApodInteractor
import com.nvoulgaris.cosmoseye.base.injection.scopes.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class ApodModule {

    @Provides
    @FragmentScope
    fun interactor(repository: ApodRepository): ApodInteractor {
        return ApodInteractor(repository)
    }

    @Provides
    @FragmentScope
    fun gateway(): ApodGateway {
        return MockApodGateway()
    }
}
