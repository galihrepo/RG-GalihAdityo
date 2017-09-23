package com.ruanggurutest.app.android.base.domain.interactor;

import com.ruanggurutest.app.android.base.domain.RequestParams;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by galihadityo on 2017-09-22.
 */

public interface Interactor<T> {

    void execute(RequestParams requestParams, DisposableObserver<T> subscriber);

    Observable<T> getExecuteObservable(RequestParams requestParams);
}
