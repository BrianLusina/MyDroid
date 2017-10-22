package com.mydroid.ui.main

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View
import com.mydroid.R
import com.mydroid.ui.base.BaseActivity
import com.mydroid.ui.bodyparts.BodyPartFragment
import com.mydroid.ui.masterlist.MasterListFragment
import com.mydroid.ui.mydroid.MyDroidActivity
import com.mydroid.utils.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_master_list.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/***
 * Main activity that will be used to select the parts to build a droid
 * [legIndex]
 * [headIndex]
 * [bodyIndex]
 *
 * [isTwoPane] will be used to track whether the screen is in Two pane or not
 * */
class MainActivity : BaseActivity(), MainView, MasterListFragment.Callback {

    @Inject
    lateinit var mainPresenter: MainPresenter<MainView>

    lateinit var fragmentManager: FragmentManager

    private var headIndex = 0
    private var bodyIndex = 0
    private var legIndex = 0

    private var isTwoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.injectMain(this)

        mainPresenter.onAttach(this)

        fragmentManager = supportFragmentManager

        mainPresenter.onViewCreated(savedInstanceState)
    }

    override fun decideUiToUse(savedInstanceState: Bundle?) {
        if (droid_layout != null) {
            isTwoPane = true
            // create new body part fragments
            if (savedInstanceState == null) {
                mainPresenter.onTwoPaneLayoutCreated()
            }
        } else {
            isTwoPane = false
        }
    }

    override fun updateView() {
        next_button.visibility = View.GONE
        grid_view.numColumns = 2
    }

    override fun createDroidFragments() {
        createHeadFragment()
        createBodyFragment()
        createLegFragment()
    }

    override fun createHeadFragment() {
        val headFragment = BodyPartFragment()

        headFragment.mImageIds = getHeads()

        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .commit()
    }

    override fun createBodyFragment() {
        val bodyFragment = BodyPartFragment()
        bodyFragment.mImageIds = getBodies()

        fragmentManager.beginTransaction()
                .add(R.id.body_container, bodyFragment)
                .commit()
    }

    override fun createLegFragment() {
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
     * NOTE: This will start a new activity on a phone only
     *
     * */
    override fun onImageSelected(position: Int) {
        val bodyPartNumber = position / 12

        val listIndex = position - bodyPartNumber * 12

        val bodyPartFragment = BodyPartFragment()

        if (isTwoPane) {
            when (bodyPartNumber) {
                0 -> {
                    bodyPartFragment.mImageIds = getHeads()
                    bodyPartFragment.mListIndex = listIndex

                    fragmentManager.beginTransaction()
                            .replace(R.id.head_container, bodyPartFragment)
                            .commit()
                }
                1 -> {
                    bodyPartFragment.mImageIds = getBodies()
                    bodyPartFragment.mListIndex = listIndex

                    fragmentManager.beginTransaction()
                            .replace(R.id.body_container, bodyPartFragment)
                            .commit()
                }
                2 -> {
                    bodyPartFragment.mImageIds = getLegs()
                    bodyPartFragment.mListIndex = listIndex

                    fragmentManager.beginTransaction()
                            .replace(R.id.leg_container, bodyPartFragment)
                            .commit()
                }
            }
        } else {
            when (bodyPartNumber) {
                0 -> {
                    headIndex = listIndex
                }

                1 -> {
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

}
