package com.ruanggurutest.app.android.game.interactor;

import com.ruanggurutest.app.android.base.domain.RequestParams;
import com.ruanggurutest.app.android.base.domain.executor.PostExecutionThread;
import com.ruanggurutest.app.android.base.domain.executor.ThreadExecutor;
import com.ruanggurutest.app.android.base.domain.interactor.UseCase;
import com.ruanggurutest.app.android.game.model.GameResponse;
import com.ruanggurutest.app.android.game.repository.GameRepository;
import com.ruanggurutest.app.android.game.source.GameDataSource;

import io.reactivex.Observable;

/**
 * Created by galihadityo on 2017-09-22.
 */

public class GameUseCase extends UseCase<GameResponse> {

    private GameDataSource gameDataSource;

    public GameUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GameDataSource gameDataSource) {
        super(threadExecutor, postExecutionThread);
        this.gameDataSource = gameDataSource;
    }

    @Override
    public Observable<GameResponse> createObservable(RequestParams requestParams) {
        return gameDataSource.getGame(requestParams);
    }

    public RequestParams getRequestParams(int amount, int category, String type) {
        RequestParams params = RequestParams.create();
        params.putInt("amount", amount);
        params.putInt("category", category);
        params.putString("type", type);
        return params;
    }
}
