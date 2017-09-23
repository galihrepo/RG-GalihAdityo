package com.ruanggurutest.app.android.base.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.ruanggurutest.app.android.R;

/**
 * Created by galihadityo on 2017-09-21.
 */

public class BaseTextViewMedium extends android.support.v7.widget.AppCompatTextView {
    public BaseTextViewMedium(Context context) {
        super(context);
        setup(context);
    }

    public BaseTextViewMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(context);
    }

    public BaseTextViewMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context);
    }

    private void setup(Context context) {
        Typeface customFont = FontCache.getTypeface(context.getString(R.string.path_roboto_medium), context);
        setTypeface(customFont);
        setIncludeFontPadding(false);
    }
}
