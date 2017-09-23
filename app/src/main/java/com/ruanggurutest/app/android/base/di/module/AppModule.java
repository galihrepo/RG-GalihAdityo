package com.ruanggurutest.app.android.base.di.module;

import android.content.Context;

import com.ruanggurutest.app.android.base.di.qualifier.ApplicationContext;
import com.ruanggurutest.app.android.base.di.scope.ApplicationScope;
import com.ruanggurutest.app.android.base.domain.executor.PostExecutionThread;
import com.ruanggurutest.app.android.base.domain.executor.ThreadExecutor;
import com.ruanggurutest.app.android.base.network.JobExecutor;
import com.ruanggurutest.app.android.base.network.UIThread;

import dagger.Module;
import dagger.Provides;

/**
 * Created by galihadityo on 2017-09-22.
 */

@Module(includes = {ActivityModule.class, NetModule.class})
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @ApplicationScope
    @Provides
    @ApplicationContext
    public Context provideContext() {
        return context.getApplicationContext();
    }

    @ApplicationScope
    @Provides
    public ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @ApplicationScope
    @Provides
    public PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

}
