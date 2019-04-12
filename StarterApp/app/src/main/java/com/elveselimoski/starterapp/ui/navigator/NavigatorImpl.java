package com.elveselimoski.starterapp.ui.navigator;

import androidx.appcompat.app.AppCompatActivity;
import com.elveselimoski.starterapp.R;
import com.elveselimoski.starterapp.ui.main.MainFragment;

import javax.inject.Inject;

public class NavigatorImpl implements Navigator {

    private final AppCompatActivity activity;

    @Inject
    NavigatorImpl(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void goToMainScreen() {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new MainFragment())
                .commit();
    }
}