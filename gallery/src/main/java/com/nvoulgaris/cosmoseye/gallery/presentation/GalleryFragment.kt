package com.nvoulgaris.cosmoseye.gallery.presentation

import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingActivity
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingFragment
import cosmoseye.nvoulgaris.com.base.gallery.R

class GalleryFragment : BaseInjectingFragment() {

    override fun onInject() {
        val activity = activity as BaseInjectingActivity<*>
        val componentCreator = activity.getComponent() as GalleryComponent.GalleryComponentCreator
        componentCreator.createGalleryComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.gallery_fragment
}
