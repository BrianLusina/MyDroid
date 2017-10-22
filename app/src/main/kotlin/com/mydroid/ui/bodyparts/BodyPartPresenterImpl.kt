package com.mydroid.ui.bodyparts

import com.mydroid.ui.base.BasePresenterImpl
import javax.inject.Inject

/**
 * @author lusinabrian on 22/10/17.
 * @Notes
 */
class BodyPartPresenterImpl<V : BodyPartView>
@Inject
constructor() : BodyPartPresenter<V>, BasePresenterImpl<V>(){

}