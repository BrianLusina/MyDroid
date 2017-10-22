package com.mydroid.ui.masterlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.mydroid.R
import com.mydroid.ui.base.BaseFragment
import com.mydroid.utils.getAll
import kotlinx.android.synthetic.main.fragment_master_list.view.*
import java.lang.ClassCastException
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

    lateinit var mCallback : Callback

    /**
     * This is to make sure that the host activity has implemented the callback*/
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            mCallback = context as Callback
        }catch (cce : ClassCastException){
            throw ClassCastException("${context.toString()} must implement ${Callback::class}")
        }
    }

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

            // Triggers the callback on the selected image on the GridView
            grid_view.onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, position, id ->
                mCallback.onImageSelected(position)
            }
        }
    }

    /**
     * Callback that will be implemented by host activity
     * This will be used when interacting with the view
     * */
    interface Callback{

        /**
         * On Image selected callback will be used to select an image at a given position
         * and display it on the detail fragment
         * @param position Position of the selected image
         * */
        fun onImageSelected(position : Int)
    }

    /**
     * Sets the callback to be used in the Fragment
     * */
    fun setCallback(mCallback : Callback){
        this.mCallback = mCallback
    }
}