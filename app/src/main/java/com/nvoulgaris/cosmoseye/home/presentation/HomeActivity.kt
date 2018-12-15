package com.nvoulgaris.cosmoseye.home.presentation

import android.os.Bundle
import com.nvoulgaris.cosmoseye.R
import com.nvoulgaris.cosmoseye.apod.presentation.ApodFragment
import com.nvoulgaris.cosmoseye.application.CosmosEyeApplication
import com.nvoulgaris.cosmoseye.base.injection.modules.ActivityModule
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingActivity
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingFragment
import com.nvoulgaris.cosmoseye.gallery.presentation.GalleryFragment
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
                R.id.bottom_navigation_apod -> show(ApodFragment())
                R.id.bottom_navigation_gallery -> show(GalleryFragment())
                R.id.bottom_navigation_mars_rover -> Timber.e("Mars rover tab")
            }
            true
        }
    }

    private fun show(fragment: BaseInjectingFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_fragment, fragment)
            .commit()
    }
}
