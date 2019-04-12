package com.elveselimoski.starterapp.di.activity

import com.elveselimoski.starterapp.di.fragment.FragmentComponent
import com.elveselimoski.starterapp.di.fragment.FragmentModule
import com.elveselimoski.starterapp.di.scope.PerActivity
import com.elveselimoski.starterapp.ui.main.MainActivity
import dagger.Subcomponent

/**
 * Created by Elvedin Selimoski on 12/6/17. mail: elveselimoski@gmail.com
 */

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun fragmentComponent(fragmentModule: FragmentModule): FragmentComponent

    fun inject(mainActivity: MainActivity)
}
