package com.mydroid.ui.main

import android.os.Bundle
import com.mydroid.ui.base.BasePresenterImpl
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Presenter implementation for Main
 */
class MainPresenterImpl<V : MainView>
@Inject
constructor() : MainPresenter<V>, BasePresenterImpl<V>() {

    override fun onViewCreated(savedInstanceState: Bundle?) {
        baseView.decideUiToUse(savedInstanceState)
    }

    override fun onTwoPaneLayoutCreated() {
        baseView.updateView()
        baseView.createDroidFragments()
    }
}