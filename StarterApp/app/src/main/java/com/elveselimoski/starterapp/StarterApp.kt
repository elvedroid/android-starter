package com.elveselimoski.starterapp

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

class StarterApp : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}