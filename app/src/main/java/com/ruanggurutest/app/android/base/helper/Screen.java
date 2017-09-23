package com.ruanggurutest.app.android.base.helper;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by galihadityo on 2017-09-21.
 */

public class Screen {

    public static Integer getWidth(Context context) {
        WindowManager window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        window.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

}
