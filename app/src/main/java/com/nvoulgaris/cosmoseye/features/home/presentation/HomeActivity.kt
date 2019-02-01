package com.nvoulgaris.cosmoseye.features.home.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import com.nvoulgaris.cosmoseye.R
import com.nvoulgaris.cosmoseye.application.CosmosEyeApplication
import com.nvoulgaris.cosmoseye.base.injection.modules.ActivityModule
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingActivity
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingFragment
import com.nvoulgaris.cosmoseye.features.apod.presentation.ApodFragment
import com.nvoulgaris.cosmoseye.features.gallery.presentation.GalleryFragment
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

    fun flipOpen(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                R.animator.card_flip_left_in, R.animator.card_flip_left_out
            )
            .replace(R.id.home_root, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun attachNavigationListener() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_navigation_apod -> showTab(ApodFragment())
                R.id.bottom_navigation_gallery -> showTab(GalleryFragment())
                R.id.bottom_navigation_mars_rover -> Timber.e("Mars rover tab")
            }
            true
        }
    }

    private fun showTab(fragment: BaseInjectingFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_fragment, fragment)
            .commit()
    }
}
