package com.mydroid.ui.masterlist

import android.os.Bundle
import com.mydroid.ui.base.BasePresenter

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Presenter for master List
 */
interface MasterListPresenter<V : MasterListView> : BasePresenter<V>{

    fun onViewCreated(savedInstanceState : Bundle?)
}