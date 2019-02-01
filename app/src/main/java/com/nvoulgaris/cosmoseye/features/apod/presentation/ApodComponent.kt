package com.nvoulgaris.cosmoseye.features.apod.presentation

import com.nvoulgaris.cosmoseye.base.injection.scopes.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ApodModule::class])
interface ApodComponent {

    fun inject(apodFragment: ApodFragment)

    interface ApodComponentCreator {

        fun createApodComponent(): ApodComponent
    }
}
