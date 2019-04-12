package com.elveselimoski.starterapp.util.scheduler

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by Elvedin Selimoski on 11/29/17. mail: elveselimoski@gmail.com
 */

class ImmediateSchedulerProvider : SchedulerProvider {

    override fun computation(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun ui(): Scheduler {
        return Schedulers.trampoline()
    }
}
