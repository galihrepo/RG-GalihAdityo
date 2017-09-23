package com.ruanggurutest.app.android.base.domain.interactor;

import com.ruanggurutest.app.android.base.domain.RequestParams;
import com.ruanggurutest.app.android.base.domain.executor.PostExecutionThread;
import com.ruanggurutest.app.android.base.domain.executor.ThreadExecutor;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by galihadityo on 2017-09-22.
 */

public abstract class UseCase<T> implements Interactor<T> {

    protected ThreadExecutor threadExecutor;
    protected PostExecutionThread postExecutionThread;
    protected Disposable subscription = Disposables.empty();

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public UseCase() {
        this(null, null);
    }

    public abstract Observable<T> createObservable(RequestParams requestParams);

    public void execute(RequestParams requestParams, DisposableObserver<T> subscriber) {
        this.subscription = createObservable(requestParams)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribeWith(subscriber);
    }

    public void execute(DisposableObserver<T> subscriber) {
        execute(null, subscriber);
    }

    public void unsubscribe() {
        if (!this.subscription.isDisposed()) {
            this.subscription.dispose();
        }
    }

    @Override
    public Observable<T> getExecuteObservable(RequestParams requestParams) {
        return createObservable(requestParams);
    }
}
