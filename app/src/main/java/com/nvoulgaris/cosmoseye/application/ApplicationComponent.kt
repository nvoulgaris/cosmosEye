package com.nvoulgaris.cosmoseye.application

import com.nvoulgaris.cosmoseye.base.injection.modules.ActivityModule
import com.nvoulgaris.cosmoseye.home.presentation.HomeActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    fun inject(app: CosmosEyeApplication)

    fun createHomeActivityComponent(module: ActivityModule): HomeActivityComponent

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: CosmosEyeApplication): Builder

        fun build(): ApplicationComponent
    }
}