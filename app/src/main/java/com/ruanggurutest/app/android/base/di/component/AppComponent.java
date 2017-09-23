package com.ruanggurutest.app.android.base.di.component;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;
import com.ruanggurutest.app.android.base.di.module.AppModule;
import com.ruanggurutest.app.android.base.di.qualifier.ActivityContext;
import com.ruanggurutest.app.android.base.di.qualifier.ApplicationContext;
import com.ruanggurutest.app.android.base.di.qualifier.RetrofitQualifier;
import com.ruanggurutest.app.android.base.di.scope.ApplicationScope;
import com.ruanggurutest.app.android.base.domain.executor.PostExecutionThread;
import com.ruanggurutest.app.android.base.domain.executor.ThreadExecutor;
import com.ruanggurutest.app.android.base.network.ApiServices;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by galihadityo on 2017-09-22.
 */

@ApplicationScope
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(Activity activity);

    @ApplicationContext
    Context context();

    @ActivityContext
    Context contextActivity();

    @RetrofitQualifier
    Retrofit serviceRetrofit();

    ApiServices apiService();

    Gson gson();

    Retrofit.Builder retrofitBuilder();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

}
