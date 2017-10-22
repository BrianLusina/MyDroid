package com.mydroid.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mydroid.di.components.ActivityComponent

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
abstract class BaseFragment : Fragment(), BaseView{
    /**
     * Gets the base activity this fragment is attached to
     * @return [BaseActivity]
     */
    lateinit var baseActivity: BaseActivity
        private set

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            baseActivity = context
            context.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retainInstance = true
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDetach() {
        super.onDetach()
    }

    /**
     * Gets the activity component of the activity this fragment is attached to
     * @return [ActivityComponent]
     */
    val activityComponent: ActivityComponent
        get() = baseActivity.activityComponent

    /**
     * Used to setup views in this fragment */
    protected abstract fun setUp(view: View)

    /**
     * before destroying the fragment, check if the attached view in the hierarchy are still bound and
     * unbind them */
    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * Callback interface for this fragment */
    interface Callback {
        /**
         * Callback for when a fragment is attached to an activity
         */
        fun onFragmentAttached()

        /**
         * Callback for when a fragment is detached from an activity
         * @param tag the fragment tag to detach
         */
        fun onFragmentDetached(tag: String)
    }
}