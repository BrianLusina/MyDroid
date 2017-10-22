package com.mydroid.ui.base

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Base Presenter for interaction between data layer and view layer
 */
interface BasePresenter<V : BaseView> {
    fun onAttach(mBaseView: V)

    fun onDetach()
}