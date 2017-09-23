package com.ruanggurutest.app.android.base.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * Created by galihadityo on 2017-09-21.
 */

public class BaseProgressBar extends LinearLayout {
    public BaseProgressBar(Context context) {
        super(context);
        setup(context);
    }

    public BaseProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context);
    }

    public BaseProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup(context);
    }

    private void setup(Context context) {
        setGravity(Gravity.CENTER);
        setClickable(true);
        setBackgroundColor(Color.WHITE);

        ProgressBar pb = new ProgressBar(context);
        addView(pb);
    }
}
