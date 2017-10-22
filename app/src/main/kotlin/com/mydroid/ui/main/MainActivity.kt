package com.mydroid.ui.main

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.widget.Toast
import com.mydroid.R
import com.mydroid.ui.base.BaseActivity
import com.mydroid.ui.bodyparts.BodyPartFragment
import com.mydroid.ui.masterlist.MasterListFragment
import com.mydroid.utils.getBodies
import com.mydroid.utils.getHeads
import com.mydroid.utils.getLegs
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView, MasterListFragment.Callback {

    @Inject
    lateinit var mainPresenter: MainPresenter<MainView>

    lateinit var fragmentManager :FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.injectMain(this)

        mainPresenter.onAttach(this)

        fragmentManager = supportFragmentManager

        mainPresenter.onViewCreated()
    }

    override fun onFragmentAttached() {
        super.onFragmentAttached()
    }

    override fun onFragmentDetached(tag: String) {
        super.onFragmentDetached(tag)
    }

    override fun onImageSelected(position: Int) {
        toast("Position clicked $position")
    }

}
