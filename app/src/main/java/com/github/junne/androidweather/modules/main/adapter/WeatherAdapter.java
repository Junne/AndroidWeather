package com.github.junne.androidweather.modules.main.adapter;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.junne.androidweather.R;
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

    public WeatherAdapter(Weather weatherData) {
        this.mWeatherData = weatherData;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == WeatherAdapter.TYPE_ONE) {
            return WeatherAdapter.TYPE_ONE;
        }

        if (position == WeatherAdapter.TYPE_TWO) {
            return WeatherAdapter.TYPE_TWO;
        }

        if (position == WeatherAdapter.TYPE_THREE) {
            return WeatherAdapter.TYPE_THREE;
        }

        if (position == WeatherAdapter.TYPE_FOUR) {
            return WeatherAdapter.TYPE_FOUR;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        switch (viewType) {
            case TYPE_ONE:
                return new NowWeatherViewHolder(
                        LayoutInflater.from(mContext).inflate(R.layout.item_temperature, parent, false));
        }

        return super.onCreateViewHolder(parent, viewType);
    }

    class NowWeatherViewHolder extends RecyclerView.ViewHolder {


    }
}
