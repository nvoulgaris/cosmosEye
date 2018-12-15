package com.nvoulgaris.cosmoseye.apod.presentation

import com.nvoulgaris.cosmoseye.apod.R
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingActivity
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingFragment

class ApodFragment : BaseInjectingFragment() {

    override fun onInject() {
        val activity = activity as BaseInjectingActivity<*>
        val componentCreator = activity.getComponent() as ApodComponent.ApodComponentCreator
        componentCreator.createApodComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.apod_fragment
}
