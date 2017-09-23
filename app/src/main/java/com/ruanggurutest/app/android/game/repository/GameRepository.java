package com.ruanggurutest.app.android.game.repository;

import com.ruanggurutest.app.android.base.domain.RequestParams;
import com.ruanggurutest.app.android.game.model.GameResponse;

import io.reactivex.Observable;

/**
 * Created by galihadityo on 2017-09-22.
 */

public interface GameRepository {

    Observable<GameResponse> getGame(RequestParams requestParams);

}
