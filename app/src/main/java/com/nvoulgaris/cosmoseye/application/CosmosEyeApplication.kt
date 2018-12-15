package com.nvoulgaris.cosmoseye.application

import android.app.Application
import android.support.annotation.CallSuper

class CosmosEyeApplication : Application() {

    private var component: ApplicationComponent? = null

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        getComponent().inject(this)
    }

    fun getComponent(): ApplicationComponent {
        return component ?: DaggerApplicationComponent.builder().application(this).build()
    }
}