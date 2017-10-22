package com.mydroid.app

import android.app.Application
import android.content.Context

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
class MyDroidApp : Application(){

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }
}