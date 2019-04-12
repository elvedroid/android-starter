package com.elveselimoski.starterapp.util.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject

/**
 * Created by Elvedin Selimoski on 11/29/17. mail: elveselimoski@gmail.com
 */

class DefaultSchedulerProvider// Prevent direct instantiation.
@Inject
constructor() : SchedulerProvider {

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
