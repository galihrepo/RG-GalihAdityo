package com.ruanggurutest.app.android.base.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.ruanggurutest.app.android.R;

/**
 * Created by galihadityo on 2017-09-23.
 */

public class BaseButton extends android.support.v7.widget.AppCompatButton {

    public BaseButton(Context context) {
        super(context);
        setup(context);
    }

    public BaseButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(context);
    }

    public BaseButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context);
    }



    private void setup(Context context) {
        Typeface customFont = FontCache.getTypeface(context.getString(R.string.path_roboto_bold), context);
        setTypeface(customFont);
        setIncludeFontPadding(false);
    }

}
