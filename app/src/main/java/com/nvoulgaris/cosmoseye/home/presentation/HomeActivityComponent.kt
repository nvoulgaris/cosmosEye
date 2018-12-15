package com.nvoulgaris.cosmoseye.home.presentation

import com.nvoulgaris.cosmoseye.base.injection.modules.ActivityModule
import com.nvoulgaris.cosmoseye.base.injection.scopes.ActivityScope
import com.nvoulgaris.cosmoseye.gallery.presentation.GalleryComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface HomeActivityComponent : GalleryComponent.GalleryComponentCreator {

    fun inject(homeActivity: HomeActivity)
}
