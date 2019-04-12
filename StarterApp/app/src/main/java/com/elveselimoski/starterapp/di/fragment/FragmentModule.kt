package com.elveselimoski.starterapp.di.fragment

import androidx.fragment.app.Fragment
import com.elveselimoski.starterapp.di.scope.PerActivity
import com.elveselimoski.starterapp.di.scope.PerFragment
import dagger.Module
import dagger.Provides

/**
 * Created by Elvedin Selimoski on 12/6/17. mail: elveselimoski@gmail.com
 */

@Module
class FragmentModule(private val fragment: Fragment) {

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerFragment
    internal fun fragment(): Fragment {
        return this.fragment
    }

}
