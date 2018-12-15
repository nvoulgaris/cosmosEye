package com.nvoulgaris.cosmoseye.base.injection.modules

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.nvoulgaris.cosmoseye.base.injection.qualifiers.ForActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity
) {

    @ForActivity
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideFragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
}
