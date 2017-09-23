package com.ruanggurutest.app.android.base;

/**
 * Created by galihadityo on 2017-09-22.
 */

public abstract class BasePresenter<T extends BaseContractView> {

    private T view;

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

}
