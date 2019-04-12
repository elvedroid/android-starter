package com.elveselimoski.starterapp.di.app

import com.elveselimoski.starterapp.StarterApp
import com.elveselimoski.starterapp.di.activity.ActivityComponent
import com.elveselimoski.starterapp.di.activity.ActivityModule
import com.elveselimoski.starterapp.di.repo.RepoModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepoModule::class])
interface AppComponent {

    fun activityComponent(activityModule: ActivityModule): ActivityComponent

    fun inject(app: StarterApp)

}
