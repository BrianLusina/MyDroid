package com.mydroid.ui.main

import android.os.Bundle
import com.mydroid.R
import com.mydroid.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView{

    @Inject
    lateinit var mainPresenter : MainPresenter<MainView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.injectMain(this)

        mainPresenter.onAttach(this)
    }
    
}
