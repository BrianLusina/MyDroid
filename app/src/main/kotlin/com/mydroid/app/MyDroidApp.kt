package com.mydroid.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.mydroid.di.components.AppComponent
import com.mydroid.di.components.DaggerAppComponent
import com.mydroid.di.module.AppModule

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
class MyDroidApp : Application(){

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        appComponent.injectApp(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}