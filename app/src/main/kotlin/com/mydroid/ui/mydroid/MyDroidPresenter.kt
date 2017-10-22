package com.mydroid.ui.mydroid

import com.mydroid.ui.base.BasePresenter
import com.mydroid.ui.main.MyDroidView

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
interface MyDroidPresenter<V : MyDroidView> : BasePresenter<V>{

    fun onViewCreated()
}