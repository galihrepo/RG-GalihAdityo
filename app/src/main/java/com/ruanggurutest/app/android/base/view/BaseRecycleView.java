package com.ruanggurutest.app.android.base.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by galihadityo on 2017-09-21.
 */

public class BaseRecycleView extends RecyclerView {

    public BaseRecycleView(Context context) {
        super(context);
    }

    public BaseRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

}
