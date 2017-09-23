package com.ruanggurutest.app.android.base.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by galihadityo on 2017-09-22.
 */

public interface PostExecutionThread {

    Scheduler getScheduler();

}
