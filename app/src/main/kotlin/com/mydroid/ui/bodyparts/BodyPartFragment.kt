package com.mydroid.ui.bodyparts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mydroid.R
import com.mydroid.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_body_parts.view.*
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Body part fragment
 */
class BodyPartFragment : BaseFragment(), BodyPartView{

    @Inject
    lateinit var bodyPartPresenter : BodyPartPresenter<BodyPartView>

    lateinit var rootView : View

    private val imageIdArrListKey = "IMAGE_ID_ARR_LIST_KEY"
    private val imageIdIndexKey = "IMAGE_ID_INDEX_KEY"

    var mImageIds = arrayListOf<Int>()
    var mListIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_body_parts, container, false)

        activityComponent.injectBodyPart(this)

        bodyPartPresenter.onAttach(this)

        bodyPartPresenter.onViewCreated(savedInstanceState)

        setUp(rootView)

        return rootView
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        bodyPartPresenter.onViewCreated(savedInstanceState)
    }

    override fun restoreViewState(savedInstanceState: Bundle?) {
        if(savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(imageIdArrListKey)
            mListIndex = savedInstanceState.getInt(imageIdIndexKey)
        }
    }

    override fun setUp(view: View) {
        with(view){
            if(mImageIds != null){
                body_part_image_view.setImageResource(mImageIds[mListIndex])
                body_part_image_view.setOnClickListener({
                    bodyPartPresenter.onBodyPartClicked()
                })
            }
        }
    }

    override fun updateBodyPartImage() {
        if (mListIndex < mImageIds.size - 1){
            mListIndex ++
        }else{
            mListIndex = 0
        }
        with(rootView){
            body_part_image_view.setImageResource(mImageIds[mListIndex])
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putIntegerArrayList(imageIdArrListKey, mImageIds)
        outState?.putInt(imageIdIndexKey, mListIndex)
        super.onSaveInstanceState(outState)
    }


}