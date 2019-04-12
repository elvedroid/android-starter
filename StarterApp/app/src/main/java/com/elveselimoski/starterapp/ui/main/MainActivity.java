package com.elveselimoski.starterapp.ui.main;

import android.os.Bundle;
import com.elveselimoski.starterapp.R;
import com.elveselimoski.starterapp.base.BaseActivity;
import com.elveselimoski.starterapp.ui.navigator.Navigator;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject Navigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigator.goToMainScreen();
    }

    @Override
    public void injectActivity() {
        getComponent().inject(this);
    }
}
