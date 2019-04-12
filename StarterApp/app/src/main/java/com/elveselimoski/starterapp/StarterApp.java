package com.elveselimoski.starterapp;

import android.content.Context;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.elveselimoski.starterapp.di.HasComponent;
import com.elveselimoski.starterapp.di.app.AppComponent;
import com.elveselimoski.starterapp.di.app.AppModule;
import com.elveselimoski.starterapp.di.app.DaggerAppComponent;
import com.elveselimoski.starterapp.di.repo.RepoModule;

import javax.inject.Inject;

public class StarterApp extends MultiDexApplication implements HasComponent<AppComponent> {

    private volatile boolean needToInject = true;
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        injectIfNecessary();
    }

    private void injectIfNecessary() {
        if (needToInject) {
            synchronized (this) {
                if (needToInject) {
                    initComponent();
                    component.inject(this);
                    if (needToInject) {
                        throw new IllegalStateException(
                                "The AppComponent did not injectIfNecessary the " + "StarterApp"
                        );
                    }
                }
            }
        }
    }

    private void initComponent() {
        component = DaggerAppComponent.builder()
                .repoModule(new RepoModule("https://translate.google.com"))
                .appModule(new AppModule(this))
                .build();
    }

    @Inject
    public void setInjected() {
        needToInject = false;
    }

    @Override
    public AppComponent getComponent() {
        return component;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
