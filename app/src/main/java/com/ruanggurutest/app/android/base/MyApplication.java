package com.ruanggurutest.app.android.base;

import android.support.multidex.MultiDexApplication;

import com.ruanggurutest.app.android.base.di.component.AppComponent;
import com.ruanggurutest.app.android.base.di.component.DaggerAppComponent;
import com.ruanggurutest.app.android.base.di.module.ActivityModule;
import com.ruanggurutest.app.android.base.di.module.AppModule;
import com.ruanggurutest.app.android.base.di.module.NetModule;

/**
 * Created by galihadityo on 2017-09-21.
 */

public class MyApplication extends MultiDexApplication {

    private DaggerAppComponent.Builder dagger;
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDI();
    }

    private void setupDI() {
        dagger = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule());
    }

    public AppComponent getApplicationComponent(ActivityModule activityModule) {
        return component = dagger.activityModule(activityModule)
                .build();
    }

}
