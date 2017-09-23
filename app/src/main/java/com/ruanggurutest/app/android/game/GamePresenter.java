package com.ruanggurutest.app.android.game;

import android.util.Log;

import com.ruanggurutest.app.android.base.BasePresenter;
import com.ruanggurutest.app.android.base.domain.DefaultSubscriber;
import com.ruanggurutest.app.android.game.interactor.GameUseCase;
import com.ruanggurutest.app.android.game.model.GameResponse;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

/**
 * Created by galihadityo on 2017-09-22.
 */

public class GamePresenter extends BasePresenter<GameContract.View> implements GameContract.Presenter {

    @Inject
    GameUseCase gameUseCase;

    @Override
    public void getGame(int amount, int category, String type) {
        gameUseCase.execute(
                gameUseCase.getRequestParams(amount, category, type),
                new DefaultSubscriber<GameResponse>(){
                    @Override
                    protected void onStart() {
                        getView().showLoading();
                    }

                    @Override
                    public void onNext(@NonNull GameResponse gameResponse) {
                            getView().onRenderGame(gameResponse);
                    }

                    @Override
                    public void onComplete() {
                        getView().hideLoading();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        try {
                            getView().onError(e.getMessage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                }
        );
    }

    @Override
    public void unsubscribe() {
        gameUseCase.unsubscribe();
    }

}
