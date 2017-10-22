package com.mydroid.ui.bodyparts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mydroid.R
import com.mydroid.ui.base.BaseFragment
import com.mydroid.utils.getHeads
import kotlinx.android.synthetic.main.fragment_body_parts.*
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
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_body_parts, container, false)

        setUp(rootView)

        body_part_image_view.setImageResource(getHeads()[0])

        return rootView
    }

    override fun setUp(view: View) {
    }

}