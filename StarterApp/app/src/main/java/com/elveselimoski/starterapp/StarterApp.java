package com.elveselimoski.starterapp;

import com.elveselimoski.starterapp.base.BaseApp;

public class StarterApp extends BaseApp {

    @Override
    protected void injectApp() {
        getComponent().inject(this);
    }
}
