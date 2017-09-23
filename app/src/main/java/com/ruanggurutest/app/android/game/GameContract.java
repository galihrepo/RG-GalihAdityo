package com.ruanggurutest.app.android.game;

import com.ruanggurutest.app.android.base.BaseContractView;
import com.ruanggurutest.app.android.game.model.GameResponse;

/**
 * Created by galihadityo on 2017-09-21.
 */

public interface GameContract {

    interface View extends BaseContractView {

        void showLoading();

        void hideLoading();

        void onRenderGame(GameResponse gameResponse);

        void onError(String error);

        void showButton();

        void hideButton();

    }

    interface Presenter {

        void getGame(int amount, int category, String type);

        void unsubscribe();

    }

}
