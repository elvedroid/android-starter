package com.elveselimoski.starterapp.di.fragment;

import com.elveselimoski.starterapp.di.scope.PerFragment;
import com.elveselimoski.starterapp.ui.main.MainFragment;
import dagger.Subcomponent;

/**
 * Created by Elvedin Selimoski on 12/6/17. mail: elveselimoski@gmail.com
 */

@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(MainFragment mainFragment);

}
