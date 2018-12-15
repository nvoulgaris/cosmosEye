package com.nvoulgaris.cosmoseye.home.presentation

import android.os.Bundle
import com.nvoulgaris.cosmoseye.R
import com.nvoulgaris.cosmoseye.application.CosmosEyeApplication
import com.nvoulgaris.cosmoseye.base.injection.modules.ActivityModule
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingActivity
import kotlinx.android.synthetic.main.home_activity.*
import timber.log.Timber

class HomeActivity : BaseInjectingActivity<HomeActivityComponent>() {

    override fun onInject(component: HomeActivityComponent?) = component?.inject(this) ?: Unit

    override fun getLayoutId(): Int = R.layout.home_activity

    override fun createComponent(): HomeActivityComponent {
        val app = application as CosmosEyeApplication
        val activityModule = ActivityModule(this)
        return app.getComponent().createHomeActivityComponent(activityModule)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachNavigationListener()
    }

    private fun attachNavigationListener() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_navigation_apod -> Timber.e("APOD tab")
                R.id.bottom_navigation_gallery -> Timber.e("Gallery tab")
                R.id.bottom_navigation_mars_rover -> Timber.e("Mars rover tab")
            }
            true
        }
    }
}
