package com.reza.rezagithub.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.reza.rezagithub.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())
        ButterKnife.bind(this)
        this.configureDagger()
        this.configureDesign()

    }

    private fun configureDagger() = (this.application as BaseApplication).appComponent.inject(this)

    abstract fun getLayoutById(): Int
    abstract fun configureDesign()

}