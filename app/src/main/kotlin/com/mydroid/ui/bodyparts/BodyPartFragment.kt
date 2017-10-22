package com.mydroid.ui.bodyparts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mydroid.R
import com.mydroid.ui.base.BaseFragment
import com.mydroid.utils.getHeads
import kotlinx.android.synthetic.main.fragment_body_parts.view.*
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
class BodyPartFragment : BaseFragment(), BodyPartView{

    @Inject
    lateinit var bodyPartPresenter : BodyPartPresenter<BodyPartView>

    lateinit var rootView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent.injectBodyPart(this)

        bodyPartPresenter.onAttach(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_body_parts, container, false)

        setUp(rootView)

        return rootView
    }

    override fun setUp(view: View) {
        with(view){
            body_part_image_view.setImageResource(getHeads()[0])
        }
    }

}