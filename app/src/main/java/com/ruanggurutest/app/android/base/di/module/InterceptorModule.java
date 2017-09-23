package com.ruanggurutest.app.android.base.di.module;

import android.content.Context;

import com.ruanggurutest.app.android.BuildConfig;
import com.ruanggurutest.app.android.base.di.qualifier.ActivityContext;
import com.ruanggurutest.app.android.base.di.scope.ApplicationScope;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by galihadityo on 2017-09-22.
 */

@Module
public class InterceptorModule {

    @ApplicationScope
    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return logging;
    }

    @ApplicationScope
    @Provides
    public Interceptor provideInterceptor(@ActivityContext final Context context) {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder reqBuilder = request.newBuilder();
                Request req = reqBuilder.build();
                return chain.proceed(req);
            }
        };
    }

}
