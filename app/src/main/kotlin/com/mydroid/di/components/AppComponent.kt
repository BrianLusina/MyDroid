package com.mydroid.di.components

import android.app.Application
import android.content.Context
import com.mydroid.app.MyDroidApp
import com.mydroid.di.module.AppModule
import com.mydroid.di.qualifiers.AppContextQualifier
import dagger.Component
import javax.inject.Singleton

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Used to inject dependencies to classes, connects classes to Modules providing the
 * dependencies
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun injectApp(myDroidApp: MyDroidApp)

    @AppContextQualifier
    fun context(): Context

    val getApplication: Application
}