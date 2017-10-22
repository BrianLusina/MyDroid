package com.mydroid.ui.main

import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.mydroid.R
import com.mydroid.ui.base.BaseActivity
import com.mydroid.ui.bodyparts.BodyPartFragment
import com.mydroid.utils.getBodies
import com.mydroid.utils.getHeads
import com.mydroid.utils.getLegs
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView{

    @Inject
    lateinit var mainPresenter : MainPresenter<MainView>

    lateinit var fragmentManager :FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.injectMain(this)

        mainPresenter.onAttach(this)

        fragmentManager = supportFragmentManager

        if (savedInstanceState == null){
            mainPresenter.onViewCreated()
        }
    }

    override fun transactHeadFragment() {
        val headFragment = BodyPartFragment()
        headFragment.mImageIds = getHeads()

        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .commit()
    }

    override fun transactBodyFragment() {
        val bodyFragment = BodyPartFragment()
        bodyFragment.mImageIds = getBodies()

        fragmentManager.beginTransaction()
                .add(R.id.body_container, bodyFragment)
                .commit()
    }

    override fun transactLegFragment() {
        val legFragment = BodyPartFragment()
        legFragment.mImageIds = getLegs()

        fragmentManager.beginTransaction()
                .add(R.id.leg_container, legFragment)
                .commit()
    }

    override fun onFragmentAttached() {
        super.onFragmentAttached()
    }

    override fun onFragmentDetached(tag: String) {
        super.onFragmentDetached(tag)
    }

}
