package com.nvoulgaris.cosmoseye.home.presentation

import com.nvoulgaris.cosmoseye.base.injection.modules.ActivityModule
import com.nvoulgaris.cosmoseye.base.injection.scopes.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface HomeActivityComponent {

    fun inject(homeActivity: HomeActivity)
}
