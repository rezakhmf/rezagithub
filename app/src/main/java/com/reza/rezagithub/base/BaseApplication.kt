package com.reza.rezagithub.base

import android.app.Application
import com.reza.rezagithub.BASE_URL
import com.reza.rezagithub.di.AppComponent
import com.reza.rezagithub.di.DaggerAppComponent
import com.reza.rezagithub.di.NetModule
import com.reza.rezagithub.di.RxJavaModule

open class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    protected open fun initDagger() : AppComponent
            = DaggerAppComponent.builder()
            .netModule(NetModule(BASE_URL))
            .rxJavaModule(RxJavaModule())
            .build()

}