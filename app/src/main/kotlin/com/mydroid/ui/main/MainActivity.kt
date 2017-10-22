package com.mydroid.ui.main

import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.mydroid.R
import com.mydroid.ui.base.BaseActivity
import com.mydroid.ui.bodyparts.BodyPartFragment
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView{

    @Inject
    lateinit var mainPresenter : MainPresenter<MainView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.injectMain(this)

        mainPresenter.onAttach(this)

        mainPresenter.onViewCreated()
    }

    override fun transactFragment() {
        val bodyFragment = BodyPartFragment()

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
                .add(R.id.frame_container, bodyFragment)
                .commit()
    }
}
