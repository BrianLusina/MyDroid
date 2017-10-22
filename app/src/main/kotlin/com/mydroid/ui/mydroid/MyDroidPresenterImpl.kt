package com.mydroid.ui.mydroid

import com.mydroid.ui.base.BasePresenterImpl
import com.mydroid.ui.main.MyDroidView
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Presenter implementation for Main
 */
class MyDroidPresenterImpl<V : MyDroidView>
@Inject
constructor() : MyDroidPresenter<V>, BasePresenterImpl<V>() {

    override fun onViewCreated() {
        baseView.transactLegFragment()
        baseView.transactBodyFragment()
        baseView.transactHeadFragment()
    }
}