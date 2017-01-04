package com.github.junne.androidweather.base;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.appcompat.BuildConfig;

/**
 * Created by baijf on 04/01/2017.
 */

public class BaseApplication extends Application {

    public static String cacheDir;
    public static Context mAppContext = null;

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
        CrashHandler.init(new CrashHandler(getApplicationContext()));
        if (!BuildConfig.DEBUG) {
            FIR.init(this);
        }
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
        LeakCanary.install(this);

        //RxUtils.unifiedErrorHandler();
        //Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    public static Context getmAppContext() {
        return mAppContext;
    }

    public static String getCachedir(){
        return cacheDir;
    }

}
