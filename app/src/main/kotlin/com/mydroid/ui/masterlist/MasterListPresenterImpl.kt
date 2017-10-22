package com.mydroid.ui.masterlist

import com.mydroid.ui.base.BasePresenterImpl
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
class MasterListPresenterImpl<V : MasterListView> @Inject constructor() : MasterListPresenter<V>, BasePresenterImpl<V>() {
}