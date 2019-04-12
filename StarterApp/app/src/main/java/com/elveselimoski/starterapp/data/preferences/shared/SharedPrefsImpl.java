package com.elveselimoski.starterapp.data.preferences.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Inject;

public class SharedPrefsImpl implements SharedPrefs {
    private final SharedPreferences sharedPreferences;

    @Inject
    SharedPrefsImpl(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
}
