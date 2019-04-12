package com.elveselimoski.starterapp.di.app;

import android.content.Context;
import com.elveselimoski.starterapp.StarterApp;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class AppModule {

    private StarterApp app;

    public AppModule(StarterApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return app.getApplicationContext();
    }
}
