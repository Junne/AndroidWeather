package com.github.junne.androidweather.modules.main.adapter;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;

import com.github.junne.androidweather.component.AnimRecyclerViewAdapter;
import com.github.junne.androidweather.modules.main.domain.Weather;

/**
 * Created by baijf on 27/12/2016.
 */

public class WeatherAdapter extends AnimRecyclerViewAdapter<RecyclerView.ViewHolder> {
    private static String TAG = WeatherAdapter.class.getSimpleName();

    private Context mContext;

    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;
    private static final int TYPE_THREE = 2;
    private static final int TYPE_FOUR = 3;

    private Weather mWeatherData;

    

}
