package com.elveselimoski.starterapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elveselimoski.starterapp.di.HasComponent
import com.elveselimoski.starterapp.di.activity.ActivityComponent
import com.elveselimoski.starterapp.di.activity.ActivityModule
import com.elveselimoski.starterapp.di.app.AppComponent

abstract class BaseActivity : AppCompatActivity(), HasComponent<ActivityComponent> {

    override fun onCreate(savedInstanceState: Bundle?) {
        injectActivity()
        super.onCreate(savedInstanceState)
    }

    abstract fun injectActivity()

    private val appComponent: AppComponent
        get() = (application as HasComponent<*>).component as AppComponent

    override val component: ActivityComponent
        get() = appComponent.activityComponent(ActivityModule(this))
}
