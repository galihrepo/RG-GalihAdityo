package com.ruanggurutest.app.android.game.di;

import com.ruanggurutest.app.android.base.di.component.AppComponent;
import com.ruanggurutest.app.android.game.GameActivity;
import com.ruanggurutest.app.android.game.GamePresenter;

import dagger.Component;

/**
 * Created by galihadityo on 2017-09-22.
 */
@GameScope
@Component(modules = GameModule.class, dependencies = AppComponent.class)
public interface GameComponent {

    void inject(GameActivity gameActivity);

    void inject(GamePresenter gamePresenter);

}
