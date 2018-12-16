package com.nvoulgaris.cosmoseye.gallery.presentation

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.nvoulgaris.cosmoseye.base.gallery.R
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingActivity
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingFragment
import kotlinx.android.synthetic.main.gallery_fragment.*
import timber.log.Timber

class GalleryFragment : BaseInjectingFragment() {

    override fun onInject() {
        val activity = activity as BaseInjectingActivity<*>
        val componentCreator = activity.getComponent() as GalleryComponent.GalleryComponentCreator
        componentCreator.createGalleryComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.gallery_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachListeners()
    }

    private fun attachListeners() {
        gallery_search_input.setOnTouchListener { _, event ->
            val DRAWABLE_RIGHT = 2;

            if(event.action == MotionEvent.ACTION_UP) {
                if(event.rawX >= (gallery_search_input.right - gallery_search_input.compoundDrawables[DRAWABLE_RIGHT].bounds.width())) {
                    Timber.e("aaaaaaaaaaaaaaaa")
                    gallery_search_input.text.clear()
                }
            }
            false
        }
    }
}
