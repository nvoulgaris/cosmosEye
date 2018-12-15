package com.nvoulgaris.cosmoseye.home.presentation

import com.nvoulgaris.cosmoseye.R
import com.nvoulgaris.cosmoseye.application.CosmosEyeApplication
import com.nvoulgaris.cosmoseye.base.injection.modules.ActivityModule
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingActivity

class HomeActivity : BaseInjectingActivity<HomeActivityComponent>() {

    override fun onInject(component: HomeActivityComponent?) = component?.inject(this) ?: Unit

    override fun getLayoutId(): Int = R.layout.home_activity

    override fun createComponent(): HomeActivityComponent {
        val app = application as CosmosEyeApplication
        val activityModule = ActivityModule(this)
        return app.getComponent().createHomeActivityComponent(activityModule)
    }
}
