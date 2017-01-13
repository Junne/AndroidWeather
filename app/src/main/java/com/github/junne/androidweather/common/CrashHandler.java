package com.github.junne.androidweather.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.github.junne.androidweather.common.utils.SharedPreferenceUtil;
import com.github.junne.androidweather.common.utils.Util;
import com.github.junne.androidweather.component.OrmLite;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by baijf on 11/01/2017.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler{

    private static Thread.UncaughtExceptionHandler defaultHandler = null;
    private Context context = null;
    private final String TAG = CrashHandler.class.getSimpleName();
    public CrashHandler(Context context) { this.context = context; }


    /**
     * @param crashHandler   初始化
     */
    public static void init(CrashHandler crashHandler) {
        defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.out.println(ex.toString());
        PLog.e(TAG, ex.toString());
        PLog.e(TAG, collectCrashDeviceInfo());
        PLog.e(TAG, getCrashInfo(ex));

        SharedPreferenceUtil.getInstance().setCityName("北京");
        OrmLite.getInstance().deleteDatabase();
        defaultHandler.uncaughtException(thread, ex);
    }



    public String getCrashInfo(Throwable ex) {
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        ex.setStackTrace(ex.getStackTrace());
        ex.printStackTrace(printWriter);
        return result.toString();
    }

    public String collectCrashDeviceInfo() {

        String versionName = Util.getVersion(context);
        String model = Build.MODEL;
        String androidVersion = Build.VERSION.RELEASE;
        String manufacturer = Build.MANUFACTURER;

        return versionName + "  " + model + "  " + androidVersion + "   " + manufacturer;
    }

}
