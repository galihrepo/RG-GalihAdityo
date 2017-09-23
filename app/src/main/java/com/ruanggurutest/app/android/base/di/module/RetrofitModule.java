package com.ruanggurutest.app.android.base.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ruanggurutest.app.android.base.di.qualifier.RetrofitQualifier;
import com.ruanggurutest.app.android.base.di.scope.ApplicationScope;
import com.ruanggurutest.app.android.base.network.ApiServices;
import com.ruanggurutest.app.android.base.network.ResponseConverter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by galihadityo on 2017-09-22.
 */

@Module
public class RetrofitModule {

    @ApplicationScope
    @Provides
    public Retrofit.Builder provideRetrofitBuilder(ResponseConverter stringResponseConverter){
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(stringResponseConverter)
                .addConverterFactory(GsonConverterFactory.create());
    }

    @ApplicationScope
    @Provides
    ResponseConverter provideStringResponseConverter(){
        return new ResponseConverter();
    }

    @ApplicationScope
    @Provides
    ApiServices apiService(@RetrofitQualifier Retrofit retrofit){
        return retrofit.create(ApiServices.class);
    }

    @ApplicationScope
    @Provides
    public Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }

}
