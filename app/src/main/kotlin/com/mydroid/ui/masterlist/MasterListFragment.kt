package com.mydroid.ui.masterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mydroid.R
import com.mydroid.ui.base.BaseFragment
import com.mydroid.utils.getAll
import kotlinx.android.synthetic.main.fragment_master_list.view.*
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Masterlist fragment for display on tablet screens
 */
class MasterListFragment : BaseFragment(), MasterListView{

    lateinit var rootView :View

    @Inject
    lateinit var masterListPresenter : MasterListPresenter<MasterListView>

    @Inject
    lateinit var masterListAdapter : MasterListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_master_list, container, false)

        activityComponent.injectMasterList(this)

        masterListPresenter.onAttach(this)

        setUp(rootView)

        masterListPresenter.onViewCreated(savedInstanceState)
        return rootView
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        masterListPresenter.onViewCreated(savedInstanceState)
    }

    override fun restoreViewState(savedInstanceState: Bundle?) {

    }

    override fun setUp(view: View) {

    }

    override fun setMasterListAdapter() {
        masterListAdapter.imageIdArrayList = getAll()
        with(rootView){
            grid_view.adapter = masterListAdapter
        }
    }
}