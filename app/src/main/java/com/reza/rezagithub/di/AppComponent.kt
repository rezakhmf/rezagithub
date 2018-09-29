package com.reza.rezagithub.di

import com.reza.rezagithub.base.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetModule::class, RepositoryModule::class, ViewmodelModule::class, RxJavaModule::class])

interface AppComponent {
    fun inject(baseActivity: BaseActivity)
}