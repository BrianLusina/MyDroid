package com.mydroid.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import com.mydroid.app.MyDroidApp
import com.mydroid.di.components.ActivityComponent
import com.mydroid.di.components.DaggerActivityComponent
import com.mydroid.di.module.ActivityModule

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Base Activity from which All activities will inherit from
 */
abstract class BaseActivity : AppCompatActivity(), BaseView, BaseFragment.Callback{

    lateinit var activityComponent : ActivityComponent
        private set
    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as MyDroidApp).appComponent)
                .activityModule(ActivityModule(this))
                .build()
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }
}