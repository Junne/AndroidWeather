package com.github.junne.androidweather.common;

import android.util.Log;

import com.github.junne.androidweather.BuildConfig;
import com.github.junne.androidweather.base.BaseApplication;

import java.io.File;

/**
 * Created by baijf on 04/01/2017.
 */

public class PLog {
    public static boolean isDebug = BuildConfig.DEBUG;
    public static final PATH = BaseApplication.cacheDir;
    public static final String PLOG_FILE_NAME = "log.txt";

    public static final boolean PLOG_WRITE_TO_FILE = true;

    public static void e(String TAG, String msg) {
        Log.e(TAG, log(msg));
        if (PLOG_WRITE_TO_FILE) {

        }
    }

    private static void writeLogToFile(String mylogtype, String tag, String msg) {




    }

    public static void isExist(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                PLog.e(e.getMessage());
            }
        }

    }



}
