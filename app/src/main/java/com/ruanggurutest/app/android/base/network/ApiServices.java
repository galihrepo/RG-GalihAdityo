package com.ruanggurutest.app.android.base.network;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by galihadityo on 2017-09-22.
 */

public interface ApiServices {

    @GET(ApiUrl.ENDPOINT)
    Observable<Response<String>> getGame(@QueryMap()Map<String, Object> params);

}
