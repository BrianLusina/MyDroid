package com.mydroid.ui.bodyparts

import android.os.Bundle
import com.mydroid.ui.base.BasePresenterImpl
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
class BodyPartPresenterImpl<V : BodyPartView>
@Inject
constructor() : BodyPartPresenter<V>, BasePresenterImpl<V>(){

    override fun onBodyPartClicked() {
        baseView.updateBodyPartImage()
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        baseView.restoreViewState(savedInstanceState)
    }

}