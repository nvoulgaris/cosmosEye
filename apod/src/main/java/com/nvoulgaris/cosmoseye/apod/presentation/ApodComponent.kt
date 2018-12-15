package com.nvoulgaris.cosmoseye.apod.presentation

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
