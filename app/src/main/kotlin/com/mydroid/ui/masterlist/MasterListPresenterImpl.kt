package com.mydroid.ui.masterlist

import android.os.Bundle
import com.mydroid.ui.base.BasePresenterImpl
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
class MasterListPresenterImpl<V : MasterListView> @Inject constructor() : MasterListPresenter<V>, BasePresenterImpl<V>() {

    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)
        baseView.setMasterListAdapter()
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        baseView.restoreViewState(savedInstanceState)
    }
}