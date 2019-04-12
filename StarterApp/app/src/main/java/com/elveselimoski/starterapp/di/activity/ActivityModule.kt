package com.elveselimoski.starterapp.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.elveselimoski.starterapp.di.scope.PerActivity
import com.elveselimoski.starterapp.ui.navigator.Navigator
import com.elveselimoski.starterapp.ui.navigator.NavigatorImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Elvedin Selimoski on 12/6/17. mail: elveselimoski@gmail.com
 */

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    internal fun activity(): AppCompatActivity {
        return this.activity
    }

    @Provides
    @PerActivity
    internal fun navigator(navigator: NavigatorImpl): Navigator {
        return navigator
    }

}
