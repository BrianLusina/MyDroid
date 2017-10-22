package com.mydroid.ui.bodyparts

import android.os.Bundle
import com.mydroid.ui.base.BasePresenter

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
interface BodyPartPresenter<V : BodyPartView> : BasePresenter<V>{

    fun onViewCreated(savedInstanceState: Bundle?)

    /**
     * Handles click events for a body part on the droid
     * */
    fun onBodyPartClicked()
}