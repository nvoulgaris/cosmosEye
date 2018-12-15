package com.nvoulgaris.cosmoseye.base.presentation

import android.content.Context
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseInjectingFragment : Fragment() {

    override fun onAttach(context: Context?) {
        onInject()

        super.onAttach(context)
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(getLayoutId(), container, false)

    abstract fun onInject()

    @LayoutRes
    abstract fun getLayoutId(): Int
}
