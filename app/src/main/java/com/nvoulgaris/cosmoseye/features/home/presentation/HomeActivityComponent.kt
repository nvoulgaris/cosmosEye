package com.nvoulgaris.cosmoseye.features.home.presentation

import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodComponent
import com.nvoulgaris.cosmoseye.base.injection.modules.ActivityModule
import com.nvoulgaris.cosmoseye.base.injection.scopes.ActivityScope
import com.nvoulgaris.cosmoseye.features.gallery.presentation.GalleryComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface HomeActivityComponent : GalleryComponent.GalleryComponentCreator, ApodComponent.ApodComponentCreator {

    fun inject(homeActivity: HomeActivity)
}
