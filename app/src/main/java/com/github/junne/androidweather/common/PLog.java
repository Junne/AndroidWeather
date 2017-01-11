package com.github.junne.androidweather.common;

import android.util.Log;

import com.github.junne.androidweather.BuildConfig;
import com.github.junne.androidweather.base.BaseApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public static void e(String msg) {
        e(getClassName(), msg);
    }

    /**
     * 写日志到文件中
     */
    private static void writeLogToFile(String mylogtype, String tag, String msg) {

        isExist(PATH);
        //isDel();
        String needWriteMessage = "\r\n"
                + Time.getNowMDHMSTime()
                + "\r\n"
                + mylogtype
                + "    "
                + tag
                + "\r\n"
                + msg;
        File file = new File(PATH, PLOG_FILE_NAME);
        try {
            FileWriter filerWriter = new FileWriter(file, true);
            BufferedWriter bufWriter = new BufferedWriter(filerWriter);
            bufWriter.write(needWriteMessage);
            bufWriter.newLine();
            bufWriter.close();
            filerWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


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

    private static String getClassName() {

        String result;
        StackTraceElement thisMethodStack = Thread.currentThread().getStackTrace()[2];
        result = thisMethodStack.getClassName();
        int lastIndex = result.lastIndexOf(".");
        result = result.substring(lastIndex + 1);

        int i = result.indexOf("$");
        return i == -1 ? result : result.substring(0, i);
    }

}
