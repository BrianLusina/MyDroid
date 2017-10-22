package com.mydroid.ui.mydroid

import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.mydroid.R
import com.mydroid.ui.base.BaseActivity
import com.mydroid.ui.bodyparts.BodyPartFragment
import com.mydroid.utils.*
import javax.inject.Inject

class MyDroidActivity : BaseActivity(), MyDroidView {

    @Inject
    lateinit var myDroidPresenter: MyDroidPresenter<MyDroidView>

    lateinit var fragmentManager :FragmentManager

    lateinit var droidBundle : Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mydroid)

        activityComponent.injectMyDroid(this)

        myDroidPresenter.onAttach(this)

        fragmentManager = supportFragmentManager

        if (savedInstanceState == null){
            myDroidPresenter.onViewCreated(savedInstanceState)
        }
    }

    override fun retrieveDroidBundle(savedInstanceState: Bundle?) {
        if (intent.extras != null || intent.getBundleExtra(DROID_BUNDLE_KEY) != null){
            droidBundle = intent.extras.getBundle(DROID_BUNDLE_KEY)
        }else if (savedInstanceState != null){
            droidBundle = savedInstanceState.getBundle(DROID_BUNDLE_KEY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putBundle(DROID_BUNDLE_KEY, droidBundle)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            droidBundle = savedInstanceState.getBundle(DROID_BUNDLE_KEY)
        }
    }

    override fun transactHeadFragment() {
        val headFragment = BodyPartFragment()
        headFragment.mImageIds = getHeads()
        headFragment.mListIndex =droidBundle.getInt(DROID_HEAD_INDEX_KEY)

        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .commit()
    }

    override fun transactBodyFragment() {
        val bodyFragment = BodyPartFragment()
        bodyFragment.mImageIds = getBodies()
        bodyFragment.mListIndex = droidBundle.getInt(DROID_BODY_INDEX_KEY)

        fragmentManager.beginTransaction()
                .add(R.id.body_container, bodyFragment)
                .commit()
    }

    override fun transactLegFragment() {
        val legFragment = BodyPartFragment()
        legFragment.mImageIds = getLegs()
        legFragment.mListIndex = droidBundle.getInt(DROID_LEGS_INDEX_KEY)
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
