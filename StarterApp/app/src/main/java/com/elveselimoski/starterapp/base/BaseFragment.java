package com.elveselimoski.starterapp.base;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.elveselimoski.starterapp.di.HasComponent;
import com.elveselimoski.starterapp.di.activity.ActivityComponent;
import com.elveselimoski.starterapp.di.fragment.FragmentComponent;
import com.elveselimoski.starterapp.di.fragment.FragmentModule;

public abstract class BaseFragment extends Fragment implements HasComponent<FragmentComponent> {

    private FragmentComponent component;

    @Override
    public void onAttach(@NonNull Context context) {
        initComponent();
        injectFragment();
        super.onAttach(context);
    }

    private void initComponent() {
        ActivityComponent activityComponent = getActivityComponent();
        if (activityComponent != null) {
            component = activityComponent.fragmentComponent(new FragmentModule(this));
        }
    }

    protected abstract void injectFragment();

    @Override
    public FragmentComponent getComponent() {
        return component;
    }

    @SuppressWarnings("unchecked")
    private ActivityComponent getActivityComponent() {
        return getActivity() == null ? null
                : ((HasComponent<ActivityComponent>) getActivity()).getComponent();
    }
}