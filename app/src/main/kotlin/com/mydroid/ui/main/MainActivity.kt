package com.mydroid.ui.main

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.widget.Toast
import com.mydroid.R
import com.mydroid.ui.base.BaseActivity
import com.mydroid.ui.bodyparts.BodyPartFragment
import com.mydroid.ui.masterlist.MasterListFragment
import com.mydroid.ui.mydroid.MyDroidActivity
import com.mydroid.utils.*
import kotlinx.android.synthetic.main.fragment_master_list.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView, MasterListFragment.Callback {

    @Inject
    lateinit var mainPresenter: MainPresenter<MainView>

    lateinit var fragmentManager :FragmentManager

    // fields with values that relate to the parts of the Droid
    private var headIndex = 0
    private var bodyIndex = 0
    private var legIndex = 0

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

    /**
     * We get the body part number for each fragment
     * The bodyPartNumber integer will be 0 for the head, 1 for the body and 2 for the legs
     * since there are 35 images, this will enable us to get the correct body part image
     * we need and pass that along the body part fragment
     * listIndex is used to store the correct index of the clicked item, this will always be
     * a value from 0-11
     *
     * After which we bundle this information and pass it along to MyDroidActivity which will
     * then create the Droid
     * */
    override fun onImageSelected(position: Int) {
        val bodyPartNumber = position / 12

        val listIndex = position - bodyPartNumber * 12

        when(listIndex){
            0 -> {
                headIndex = listIndex
            }

            1 ->{
                bodyIndex = listIndex
            }

            2 -> {
                legIndex = listIndex
            }
        }

        val bundle = Bundle()
        bundle.putInt(DROID_HEAD_INDEX_KEY, headIndex)
        bundle.putInt(DROID_BODY_INDEX_KEY, bodyIndex)
        bundle.putInt(DROID_LEGS_INDEX_KEY, legIndex)

        next_button.setOnClickListener({
            startActivity(intentFor<MyDroidActivity>(DROID_BUNDLE_KEY to bundle))
        })
    }

}
