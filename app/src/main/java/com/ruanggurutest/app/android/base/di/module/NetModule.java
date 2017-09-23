package com.ruanggurutest.app.android.base.di.module;

import com.ruanggurutest.app.android.base.di.qualifier.RetrofitQualifier;
import com.ruanggurutest.app.android.base.di.scope.ApplicationScope;
import com.ruanggurutest.app.android.base.network.ApiUrl;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by galihadityo on 2017-09-22.
 */

@Module(includes = {OkHttpClientModule.class, RetrofitModule.class})
public class NetModule {

    @RetrofitQualifier
    @ApplicationScope
    @Provides
    public Retrofit provideRetrofit(Retrofit.Builder retrofitBuilder, OkHttpClient httpClient){
        return retrofitBuilder.baseUrl(ApiUrl.BASE_URL).client(httpClient).build();
    }

}
