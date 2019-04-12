package com.elveselimoski.starterapp.base;

import android.content.Context;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.elveselimoski.starterapp.di.HasComponent;
import com.elveselimoski.starterapp.di.app.AppComponent;
import com.elveselimoski.starterapp.di.app.AppModule;
import com.elveselimoski.starterapp.di.app.DaggerAppComponent;
import com.elveselimoski.starterapp.di.repo.RepoModule;

import javax.inject.Inject;

public abstract class BaseApp extends MultiDexApplication implements HasComponent<AppComponent> {

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
                    initAppComponent();
                    injectApp();
                    if (needToInject) {
                        throw new IllegalStateException(
                                "The AppComponent did not injectIfNecessary the App"
                        );
                    }
                }
            }
        }
    }

    protected abstract void injectApp();

    private void initAppComponent() {
        component = DaggerAppComponent.builder()
                .repoModule(new RepoModule("https://restapi.com"))
                .appModule(new AppModule(this))
                .build();
    }

    @Inject
    public void setInjected() {
        needToInject = false;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public AppComponent getComponent() {
        return component;
    }

}
