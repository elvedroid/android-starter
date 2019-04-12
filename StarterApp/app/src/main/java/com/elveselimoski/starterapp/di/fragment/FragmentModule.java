package com.elveselimoski.starterapp.di.fragment;

import androidx.fragment.app.Fragment;
import com.elveselimoski.starterapp.di.scope.PerFragment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Elvedin Selimoski on 12/6/17. mail: elveselimoski@gmail.com
 */

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment fragment() {
        return this.fragment;
    }

}
