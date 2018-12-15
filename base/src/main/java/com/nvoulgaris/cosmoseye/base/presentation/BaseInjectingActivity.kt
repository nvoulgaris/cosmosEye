package com.nvoulgaris.cosmoseye.base.presentation

import android.os.Bundle

abstract class BaseInjectingActivity<Component> : BaseActivity() {

    private var component: Component? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        component = createComponent()
        onInject(component)

        super.onCreate(savedInstanceState)
    }

    fun getComponent(): Component? {
        return component
    }

    abstract fun onInject(component: Component?)

    abstract fun createComponent(): Component
}
