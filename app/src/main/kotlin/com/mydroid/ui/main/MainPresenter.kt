package com.mydroid.ui.main

import android.os.Bundle
import com.mydroid.ui.base.BasePresenter

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
interface MainPresenter<V : MainView> : BasePresenter<V>{

    fun onViewCreated(savedInstanceState: Bundle?)

    /**
     * when a 2 pane layout is created, we initialize the fragments of our Droid
     * */
    fun onTwoPaneLayoutCreated()
}