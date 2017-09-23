package com.ruanggurutest.app.android.base.view;

import android.content.Context;
import android.util.AttributeSet;

import com.ruanggurutest.app.android.R;

/**
 * Created by galihadityo on 2017-09-21.
 */

public class BaseImageButton extends android.support.v7.widget.AppCompatImageButton {

    public BaseImageButton(Context context) {
        super(context);
        setup();
    }

    public BaseImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public BaseImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        setBackgroundResource(R.drawable.background_button_dark);
    }
}
