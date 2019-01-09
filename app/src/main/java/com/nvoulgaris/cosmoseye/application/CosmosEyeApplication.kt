package com.nvoulgaris.cosmoseye.application

import android.app.Application
import android.support.annotation.CallSuper
import com.nvoulgaris.cosmoseye.BuildConfig
import timber.log.Timber

class CosmosEyeApplication : Application() {

    private var component: ApplicationComponent? = null

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        getComponent().inject(this)
        configureLogging()
    }

    fun getComponent(): ApplicationComponent =
        component ?: DaggerApplicationComponent.builder().application(this).build()

    private fun configureLogging() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}
