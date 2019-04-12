package com.elveselimoski.starterapp.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.elveselimoski.starterapp.di.HasComponent;
import com.elveselimoski.starterapp.di.activity.ActivityComponent;
import com.elveselimoski.starterapp.di.activity.ActivityModule;
import com.elveselimoski.starterapp.di.app.AppComponent;

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<ActivityComponent> {

    private ActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initComponent();
        injectActivity();
        super.onCreate(savedInstanceState);
    }

    private void initComponent() {
        component = getAppComponent().activityComponent(new ActivityModule(this));
    }

    protected abstract void injectActivity();

    @SuppressWarnings("unchecked")
    protected AppComponent getAppComponent() {
        return ((HasComponent<AppComponent>) getApplication()).getComponent();
    }

    @Override
    public ActivityComponent getComponent() {
        return component;
    }
}
