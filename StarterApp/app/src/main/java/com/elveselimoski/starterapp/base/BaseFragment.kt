package com.elveselimoski.starterapp.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.elveselimoski.starterapp.di.HasComponent
import com.elveselimoski.starterapp.di.activity.ActivityComponent
import com.elveselimoski.starterapp.di.fragment.FragmentComponent
import com.elveselimoski.starterapp.di.fragment.FragmentModule

abstract class BaseFragment : Fragment(), HasComponent<FragmentComponent> {

    override fun onAttach(context: Context) {
        injectFragment()
        super.onAttach(context)
    }

    abstract fun injectFragment()

    override val component: FragmentComponent
        get() = activityComponent.fragmentComponent(FragmentModule(this))

    private val activityComponent: ActivityComponent
        get() = (activity as HasComponent<*>).component as ActivityComponent

}