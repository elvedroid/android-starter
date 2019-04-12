package com.elveselimoski.starterapp.util.scheduler;

import androidx.annotation.NonNull;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

/**
 * Created by Elvedin Selimoski on 11/29/17. mail: elveselimoski@gmail.com
 */

public class DefaultSchedulerProvider implements SchedulerProvider {

    // Prevent direct instantiation.
    @Inject
    DefaultSchedulerProvider() {
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
