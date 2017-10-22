package com.mydroid.ui.main

import android.os.Bundle
import com.mydroid.ui.base.BaseView

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
interface MainView : BaseView {

    /**
     * This will be used to determine the Pane to display
     * IF we can retrieve the droid layout, set the pane display to True and hide elements
     * we will not use in a two pane layout
     * */
    fun decideUiToUse(savedInstanceState: Bundle?)

    /**
     * This will update the UI to fit a 2 pane layout, hiding the next button and setting
     * Grid View*/
    fun updateView()

    /**
     * Creates the droid fragments to use for building our Droid
     * This will be created when the screen is in 2 Pane layout
     * */
    fun createDroidFragments()

    /**
     * Create Head fragment
     * */
    fun createHeadFragment()

    /**
     * Create Body Fragment
     * */
    fun createBodyFragment()

    /**
     * Create leg fragment
     * */
    fun createLegFragment()
}