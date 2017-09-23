package com.ruanggurutest.app.android.game.mapper;

import com.google.gson.Gson;
import com.ruanggurutest.app.android.game.model.GameResponse;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * Created by galihadityo on 2017-09-22.
 */

public class GameMapper implements Function<Response<String>, GameResponse> {

    private Gson gson;

    public GameMapper(Gson gson) {
        this.gson = gson;
    }

    @Override
    public GameResponse apply(@NonNull Response<String> stringResponse) throws Exception {
        GameResponse response = new GameResponse();
        if (stringResponse.isSuccessful()) {
            response = gson.fromJson(stringResponse.body(), GameResponse.class);
        } else {
            response.setResults(null);
        }

        return response;
    }
}
