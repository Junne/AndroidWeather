package com.github.junne.androidweather.common;

import android.widget.Toast;

import com.github.junne.androidweather.base.BaseApplication;

/**
 * Created by baijf on 04/01/2017.
 */

public class ToastUtil {

    public static void showShort(String msg) {
        Toast.makeText(BaseApplication.getmAppContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        Toast.makeText(BaseApplication.getmAppContext(), msg, Toast.LENGTH_LONG).show();
    }

}
