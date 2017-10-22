package com.mydroid.ui.mydroid

import android.os.Bundle
import com.mydroid.ui.base.BasePresenter

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
interface MyDroidPresenter<V : MyDroidView> : BasePresenter<V>{

    fun onViewCreated(savedInstanceState : Bundle?)
}