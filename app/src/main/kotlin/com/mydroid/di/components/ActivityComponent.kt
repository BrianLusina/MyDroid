package com.mydroid.di.components

import com.mydroid.di.module.ActivityModule
import com.mydroid.di.scopes.ActivityScope
import com.mydroid.ui.bodyparts.BodyPartFragment
import com.mydroid.ui.main.MainActivity
import com.mydroid.ui.masterlist.MasterListFragment
import com.mydroid.ui.mydroid.MyDroidActivity
import dagger.Component

/**
 * @author lusinabrian on 22/10/17.
 * @Notes Will inject dependencies into Activities and Fragment Views
 */
@ActivityScope
@Component(modules = arrayOf(ActivityModule::class),
        dependencies = arrayOf(AppComponent::class))
interface ActivityComponent {

    fun injectMain(mainActivity: MainActivity)

    fun injectMyDroid(myDroidActivity: MyDroidActivity)

    fun injectBodyPart(bodyPartFragment: BodyPartFragment)

    fun injectMasterList(masterListFragment: MasterListFragment)
}