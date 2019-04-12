package com.elveselimoski.starterapp.di.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.elveselimoski.starterapp.di.scope.PerActivity;
import com.elveselimoski.starterapp.ui.navigator.Navigator;
import com.elveselimoski.starterapp.ui.navigator.NavigatorImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Elvedin Selimoski on 12/6/17. mail: elveselimoski@gmail.com
 */

@Module
public class ActivityModule {
    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    AppCompatActivity activity() {
        return this.activity;
    }

    @Provides
    @PerActivity
    Navigator navigator(NavigatorImpl navigator) {
        return navigator;
    }

}
