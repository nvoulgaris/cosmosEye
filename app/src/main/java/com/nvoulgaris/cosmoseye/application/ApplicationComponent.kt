package com.nvoulgaris.cosmoseye.application

import android.content.Context
import com.nvoulgaris.cosmoseye.base.injection.modules.ActivityModule
import com.nvoulgaris.cosmoseye.features.home.presentation.HomeActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(app: CosmosEyeApplication)

    fun createHomeActivityComponent(module: ActivityModule): HomeActivityComponent

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: CosmosEyeApplication): Builder

        @BindsInstance
        fun context(@Named("appContext") context: Context): Builder

        fun build(): ApplicationComponent
    }
}
