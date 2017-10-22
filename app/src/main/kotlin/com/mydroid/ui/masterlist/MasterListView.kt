package com.mydroid.ui.masterlist

import android.os.Bundle
import com.mydroid.ui.base.BaseView

/**
 * @author lusinabrian on 22/10/17.
 * @Notes View interface for the Master List fragment
 */
interface MasterListView : BaseView{

    fun setMasterListAdapter()

    fun restoreViewState(savedInstanceState : Bundle?)
}