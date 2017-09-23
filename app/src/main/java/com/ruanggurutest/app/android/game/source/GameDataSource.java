package com.ruanggurutest.app.android.game.source;

import com.ruanggurutest.app.android.base.domain.RequestParams;
import com.ruanggurutest.app.android.base.network.ApiServices;
import com.ruanggurutest.app.android.game.mapper.GameMapper;
import com.ruanggurutest.app.android.game.model.GameResponse;

import io.reactivex.Observable;

/**
 * Created by galihadityo on 2017-09-22.
 */

public class GameDataSource {

    private GameMapper gameMapper;
    private ApiServices apiServices;

    public GameDataSource(ApiServices apiServices, GameMapper gameMapper) {
        this.apiServices = apiServices;
        this.gameMapper = gameMapper;
    }

    public Observable<GameResponse> getGame(RequestParams requestParams) {
        return apiServices.getGame(requestParams.getParameters()).map(gameMapper);
    }

}
