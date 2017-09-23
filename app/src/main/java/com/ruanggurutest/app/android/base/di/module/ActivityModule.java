package com.ruanggurutest.app.android.base.di.module;

import android.content.Context;
import android.content.ContextWrapper;

import com.ruanggurutest.app.android.base.di.qualifier.ActivityContext;
import com.ruanggurutest.app.android.base.di.qualifier.ApplicationContext;
import com.ruanggurutest.app.android.base.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by galihadityo on 2017-09-22.
 */

@Module
public class ActivityModule {

    private final ContextWrapper context;

    public ActivityModule(ContextWrapper context) {
        this.context = context;
    }

    @ApplicationScope
    @Provides
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}
