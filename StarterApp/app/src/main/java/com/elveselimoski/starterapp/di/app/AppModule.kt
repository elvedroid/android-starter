package com.elveselimoski.starterapp.di.app

import android.content.Context
import com.elveselimoski.starterapp.StarterApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: StarterApp) {

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return app.applicationContext
    }
}
