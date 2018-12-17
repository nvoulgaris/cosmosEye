package com.nvoulgaris.cosmoseye.apod.presentation

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.nvoulgaris.cosmoseye.apod.R
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingActivity
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingFragment
import javax.inject.Inject

class ApodFragment : BaseInjectingFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onInject() {
        val activity = activity as BaseInjectingActivity<*>
        val componentCreator = activity.getComponent() as ApodComponent.ApodComponentCreator
        componentCreator.createApodComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.apod_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(ApodViewModel::class.java)
    }
}
