package com.elveselimoski.starterapp.util.scheduler

import io.reactivex.Scheduler

/**
 * Created by Elvedin Selimoski on 11/21/17. mail: elveselimoski@gmail.com
 */

interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}
