package com.elveselimoski.starterapp.ui.main

import android.os.Bundle
import com.elveselimoski.starterapp.R
import com.elveselimoski.starterapp.base.BaseActivity
import com.elveselimoski.starterapp.ui.navigator.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.goToMainScreen()
    }

    override fun injectActivity() {
        component.inject(this)
    }
}
