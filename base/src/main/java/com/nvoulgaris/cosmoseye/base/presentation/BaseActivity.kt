package com.nvoulgaris.cosmoseye.base.presentation

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(getLayoutId())
        super.onCreate(savedInstanceState)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
}
