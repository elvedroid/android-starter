package com.elveselimoski.starterapp.util.scheduler;

import androidx.annotation.NonNull;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

/**
 * Created by Elvedin Selimoski on 11/29/17. mail: elveselimoski@gmail.com
 */

public class ImmediateSchedulerProvider implements SchedulerProvider {

    @Inject
    ImmediateSchedulerProvider() {
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.trampoline();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.trampoline();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }
}
