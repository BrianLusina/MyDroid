package com.mydroid.ui.bodyparts

import android.os.Bundle
import com.mydroid.ui.base.BaseView

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
interface BodyPartView : BaseView{

    /**
     * Updates the body part image
     * */
    fun updateBodyPartImage()

    /**
     * Restores state from bundle
     * */
    fun restoreViewState(savedInstanceState : Bundle?)
}