package com.elveselimoski.starterapp

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.elveselimoski.starterapp.di.HasComponent
import com.elveselimoski.starterapp.di.app.AppComponent
import com.elveselimoski.starterapp.di.app.AppModule
import com.elveselimoski.starterapp.di.app.DaggerAppComponent
import com.elveselimoski.starterapp.di.repo.RepoModule
import javax.inject.Inject

class StarterApp : MultiDexApplication(), HasComponent<AppComponent> {

    @Volatile
    private var needToInject = true

    override fun onCreate() {
        super.onCreate()
        injectIfNecessary()
    }

    private fun injectIfNecessary() {
        if (needToInject) {
            synchronized(this) {
                if (needToInject) {
                    component.inject(this)
                    if (needToInject) {
                        throw IllegalStateException(
                            "The AppComponent did not injectIfNecessary the " + "StarterApp"
                        )
                    }
                }
            }
        }
    }

    override val component: AppComponent = DaggerAppComponent.builder()
        .repoModule(RepoModule("https://translate.google.com"))
        .appModule(AppModule(this))
        .build()

    @Inject
    fun setInjected() {
        needToInject = false
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}