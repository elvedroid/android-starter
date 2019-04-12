package com.elveselimoski.starterapp.util.scheduler;

import androidx.annotation.NonNull;
import io.reactivex.Scheduler;

/**
 * Created by Elvedin Selimoski on 11/21/17. mail: elveselimoski@gmail.com
 */

public interface SchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
