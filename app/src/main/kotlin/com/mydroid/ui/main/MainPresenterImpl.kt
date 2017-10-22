package com.mydroid.ui.main

import com.mydroid.ui.base.BasePresenterImpl
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Presenter implementation for Main
 */
class MainPresenterImpl<V : MainView>
@Inject
constructor() : MainPresenter<V>, BasePresenterImpl<V>() {

    override fun onViewCreated() {
        baseView.transactLegFragment()
        baseView.transactBodyFragment()
        baseView.transactHeadFragment()
    }
}