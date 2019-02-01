package com.nvoulgaris.cosmoseye.features.apod.presentation

import com.nvoulgaris.cosmoseye.features.apod.data.ApodGateway
import com.nvoulgaris.cosmoseye.features.apod.data.ApodRepository
import com.nvoulgaris.cosmoseye.features.apod.domain.ApodInteractor
import com.nvoulgaris.cosmoseye.features.apod.domain.ApodsDbMapper
import com.nvoulgaris.cosmoseye.base.data.apod.ApodDao
import com.nvoulgaris.cosmoseye.base.injection.scopes.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class ApodModule {

    @Provides
    @FragmentScope
    fun provideInteractor(repository: ApodRepository): ApodInteractor = ApodInteractor(repository)

    @Provides
    @FragmentScope
    fun provideRepository(dao: ApodDao, mapper: ApodsDbMapper, gateway: ApodGateway): ApodRepository =
        ApodRepository(dao, mapper, gateway)
}
