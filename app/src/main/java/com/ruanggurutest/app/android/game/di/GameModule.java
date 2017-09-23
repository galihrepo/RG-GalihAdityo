package com.ruanggurutest.app.android.game.di;

import com.google.gson.Gson;
import com.ruanggurutest.app.android.base.di.qualifier.ActivityContext;
import com.ruanggurutest.app.android.base.domain.executor.PostExecutionThread;
import com.ruanggurutest.app.android.base.domain.executor.ThreadExecutor;
import com.ruanggurutest.app.android.base.network.ApiServices;
import com.ruanggurutest.app.android.game.GamePresenter;
import com.ruanggurutest.app.android.game.interactor.GameUseCase;
import com.ruanggurutest.app.android.game.mapper.GameMapper;
import com.ruanggurutest.app.android.game.repository.GameRepository;
import com.ruanggurutest.app.android.game.source.GameDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * Created by galihadityo on 2017-09-22.
 */

@Module
public class GameModule {

    @GameScope
    @Provides
    GameUseCase gameUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, GameDataSource gameDataSource) {
        return new GameUseCase(threadExecutor, postExecutionThread, gameDataSource);
    }

    @GameScope
    @Provides
    GamePresenter gamePresenter() {
        return new GamePresenter();
    }

    @GameScope
    @Provides
    GameMapper gameMapper(Gson gson) {
        return new GameMapper(gson);
    }

    @GameScope
    @Provides
    GameDataSource gameDataSource(ApiServices apiServices, GameMapper gameMapper) {
        return new GameDataSource(apiServices, gameMapper);
    }

}
