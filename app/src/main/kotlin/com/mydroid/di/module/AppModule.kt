package com.mydroid.di.module

import android.app.Application
import android.content.Context
import com.mydroid.di.qualifiers.AppContextQualifier
import dagger.Module
import dagger.Provides

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Module that provides dependencies to requiring classes
 */
@Module
class AppModule(val mApplication: Application) {

    @Provides
    @AppContextQualifier
    fun provideContext(): Context {
        return mApplication
    }

    @Provides
    fun provideApplication(): Application {
        return mApplication
    }

}