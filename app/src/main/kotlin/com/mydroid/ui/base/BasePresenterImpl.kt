package com.mydroid.ui.base

/**
 * @author lusinabrian on 22/10/17.
 * @Notes BasePresenter implementation
 */
open class BasePresenterImpl <V : BaseView>: BasePresenter<V>{

    lateinit var baseView: V
        private set

    override fun onAttach(mBaseView: V) {
        this.baseView = mBaseView
    }

    override fun onDetach() {

    }
    /**
     * Checks if the view has been attached */
    open val isViewAttached: Boolean
        get() = baseView != null

    /**
     * Checks if the view has been attached
     * @throws BaseViewNotAttachedException error that is thrown when the view is not attached.
     * *
     */
    fun checkViewAttached() {
        check(!isViewAttached) { BaseViewNotAttachedException() }
    }

    /**
     * Custom runtime exception that is thrown when an a request of data is made to the presenter before
     * attaching the view.
     */
    class BaseViewNotAttachedException : RuntimeException("Please call Presenter.onAttach(AppBaseView) before requesting data to Presenter")
}