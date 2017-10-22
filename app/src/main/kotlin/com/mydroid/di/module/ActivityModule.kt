package com.mydroid.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.mydroid.di.scopes.ActivityScope
import com.mydroid.ui.bodyparts.BodyPartPresenter
import com.mydroid.ui.bodyparts.BodyPartPresenterImpl
import com.mydroid.ui.bodyparts.BodyPartView
import com.mydroid.ui.mydroid.MyDroidPresenter
import com.mydroid.ui.main.MyDroidPresenterImpl
import com.mydroid.ui.main.MyDroidView
import com.mydroid.ui.masterlist.MasterListPresenter
import com.mydroid.ui.masterlist.MasterListPresenterImpl
import com.mydroid.ui.masterlist.MasterListView
import dagger.Module
import dagger.Provides

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Used to provide dependencies for Activities and Fragments
 */

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun provideContext(): Context {
        return mActivity
    }

    @Provides
    fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    @ActivityScope
    fun provideMainPresenter(myDroidPresenter: MyDroidPresenterImpl<MyDroidView>)
            : MyDroidPresenter<MyDroidView> {
        return myDroidPresenter
    }

    @Provides
    @ActivityScope
    fun provideBodyPartPresenter(bodyPartPresenter: BodyPartPresenterImpl<BodyPartView>)
            : BodyPartPresenter<BodyPartView> {
        return bodyPartPresenter
    }

    @Provides
    @ActivityScope
    fun provideMasterListPresenter(masterListPresenter: MasterListPresenterImpl<MasterListView>)
            : MasterListPresenter<MasterListView> {
        return masterListPresenter
    }
}