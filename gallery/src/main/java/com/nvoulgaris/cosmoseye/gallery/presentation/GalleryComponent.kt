package com.nvoulgaris.cosmoseye.gallery.presentation

import com.nvoulgaris.cosmoseye.base.injection.scopes.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [GalleryModule::class])
interface GalleryComponent {

    fun inject(galleryFragment: GalleryFragment)

    interface GalleryComponentCreator {

        fun createGalleryComponent(): GalleryComponent
    }
}