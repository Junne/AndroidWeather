package com.github.junne.androidweather.common.utils;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;

import com.github.junne.androidweather.base.BaseApplication;

/**
 * Created by baijf on 12/01/2017.
 */

public class SharedPreferenceUtil {

    public static final String CITY_NAME = "城市";
    public static final String HOUR = "current_hour";
    public static final String CHANGE_ICONS = "change_icons";
    public static final String CLEAR_CACHE = "clear_cache";
    public static final String AUTO_UPDATE = "change_update_time";
    public static final String NOTIFICATION_MODEL = "notification_model";
    public static final String ANIM_START = "animation_start";

    public static int ONE_HOUR = 1000 * 60 * 60;

    private SharedPreferences mPrefs;

    public static SharedPreferenceUtil getInstance() { return  SPHolder.sInstance; }

    private static class SPHolder {
        private static final SharedPreferenceUtil sInstance = new SharedPreferenceUtil();
    }

    private SharedPreferenceUtil() {
        mPrefs = BaseApplication.getmAppContext().getSharedPreferences("setting", Context.MODE_PRIVATE);
    }

    public SharedPreferenceUtil putInt(String key, int value) {
        mPrefs.edit().putInt(key, value).apply();
        return this;
    }

    public int getInt(String key, int defValue) {
        return mPrefs.getInt(key, defValue);
    }

    public SharedPreferenceUtil putString(String key, String value) {
        mPrefs.edit().putString(key, value).apply();
        return this;
    }

    public String getString(String key, String defValue) {
        return  mPrefs.getString(key, defValue); }

    public SharedPreferenceUtil putBoolean(String key, boolean value) {
        mPrefs.edit().putBoolean(key, value).apply();
        return this;
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mPrefs.getBoolean(key, defValue);
    }

    public void setCurrentHour(int h) { mPrefs.edit().putInt(HOUR, h).apply();}

    public int getCurrentHour() { return mPrefs.getInt(HOUR, 0);}

    public void setIconType(int type) { mPrefs.edit().putInt(CHANGE_ICONS, type).apply();}

    public int getIconType() { return mPrefs.getInt(CHANGE_ICONS, 0);}

    public void setAutoUpdate(int t) { mPrefs.edit().putInt(AUTO_UPDATE, t).apply();}

    public int getAutoUpdate() { return mPrefs.getInt(AUTO_UPDATE, 3);}

    public void setCityName(String name) { mPrefs.edit().putString(CITY_NAME, name).apply();}

    public String getCityName() { return mPrefs.getString(CITY_NAME, "北京");}

    public void setNotificationModel(int t) { mPrefs.edit().putInt(NOTIFICATION_MODEL, t).apply();}

    public int getNotificationModel() {
        return mPrefs.getInt(NOTIFICATION_MODEL, Notification.FLAG_ONGOING_EVENT);
    }

    public void setMainAnim(boolean b) { mPrefs.edit().putBoolean(ANIM_START, b).apply();}

    public boolean getMainAnim() {return  mPrefs.getBoolean(ANIM_START, false);}


}
