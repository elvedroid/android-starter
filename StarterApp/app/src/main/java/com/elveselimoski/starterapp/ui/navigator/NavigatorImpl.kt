package com.elveselimoski.starterapp.ui.navigator

import androidx.appcompat.app.AppCompatActivity
import com.elveselimoski.starterapp.R
import com.elveselimoski.starterapp.ui.main.MainFragment
import javax.inject.Inject

class NavigatorImpl @Inject constructor(val activity: AppCompatActivity) : Navigator {
    override fun goToMainScreen() {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }

}