package com.github.junne.androidweather.common.utils;

import android.annotation.SuppressLint;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Date;

/**
 * Created by baijf on 05/01/2017.
 */

public class Time {


    /**
     * yyyy-MM-dd HH:mm:ss
     */
    @SuppressLint("SimpleDateFormat")
    public static String getNowYMDHMSTime() {
        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return mDateFormat.format(new Date());
    }

    /**
     * MM-dd HH:mm:ss
     */
    @SuppressLint("SimpleDateFormat")
    public static String getNowMDHMSTime() {
        SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
        return mDateFormat.format(new Date());
    }


    /**
     * yyyy-MM-dd
     */
    @SuppressLint("SimpleDateFormat")
    public static String getNowYMD() {
        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return mDateFormat.format(new Date());
    }

    /**
     * @param date
     * @return yyyy-MM-dd
     */
    @SuppressLint("SimpleDateFormat")
    public static String getYMD(Date date) {
        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return mDateFormat.format(date);
    }

    /**
     * @param date
     * @return MM-dd
     */
    @SuppressLint("SimpleDateFormat")
    public static String getMD(Date date) {
        SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd");
        return mDateFormat.format(date);
    }

}
