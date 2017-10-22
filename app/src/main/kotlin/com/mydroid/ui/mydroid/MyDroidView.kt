package com.mydroid.ui.mydroid

import android.os.Bundle
import com.mydroid.ui.base.BaseView

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
interface MyDroidView : BaseView{

    /**
     * Retrieves the droid bundle sent
     * @param savedInstanceState State of bundle saved in view
     * */
    fun retrieveDroidBundle(savedInstanceState : Bundle?)

    fun transactHeadFragment()

    fun transactBodyFragment()

    fun transactLegFragment()
}