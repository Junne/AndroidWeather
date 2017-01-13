package com.github.junne.androidweather.modules.main.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.junne.androidweather.R;
import com.github.junne.androidweather.common.PLog;
import com.github.junne.androidweather.common.utils.SharedPreferenceUtil;
import com.github.junne.androidweather.common.utils.Util;
import com.github.junne.androidweather.component.AnimRecyclerViewAdapter;
import com.github.junne.androidweather.component.ImageLoader;
import com.github.junne.androidweather.modules.main.domain.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;

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
            case TYPE_TWO:
                return

        }

        return super.onCreateViewHolder(parent, viewType);
    }

    class NowWeatherViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.weather_icon)
        ImageView weatherIcon;
        @BindView(R.id.temp_flu)
        TextView tempFlu;
        @BindView(R.id.temp_max)
        TextView tempMax;
        @BindView(R.id.temp_min)
        TextView tempMin;
        @BindView(R.id.temp_pm)
        TextView tempPm;
        @BindView(R.id.temp_quality)
        TextView tempQuality;
        @BindView(R.id.cardView)
        CardView cardView;


        NowWeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Weather weather) {
            try {
                tempFlu.setText(String.format("%s℃", weather.now.tmp));
                tempMax.setText(String.format("↑ %s ℃", weather.dailyForecast.get(0).tmp.max));
                tempMin.setText(String.format("↓ %s ℃", weather.dailyForecast.get(0).tmp.min));

                tempPm.setText(String.format("PM2.5: %s μg/m³", Util.safeText(weather.aqi.city.pm25)));
                tempQuality.setText(Util.safeText("空气质量： ", weather.aqi.city.qlty));

                ImageLoader.load(itemView.getContext(),
                        SharedPreferenceUtil.getInstance().getInt(weather.now.cond.txt, R.mipmap.none),
                        weatherIcon);
            } catch (Exception e) {
                PLog.e(TAG, e.toString());
            }
        }
    }

    private class HoursWeatherViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout itemHourInfoLinearlayout;
        private TextView[] mClock = new TextView[mWeatherData.hourlyForecast.size()];
        private TextView[] mTemp = new TextView[mWeatherData.hourlyForecast.size()];
        private TextView[] mHumidity = new TextView[mWeatherData.hourlyForecast.size()];
        private TextView[] mWind = new TextView[mWeatherData.hourlyForecast.size()];

        HoursWeatherViewHolder(View itemView) {
            super(itemView);
            itemHourInfoLinearlayout = (LinearLayout) itemView.findViewById(R.id.item_hour_info_linearlayout);

            for (int i = 0; i < mWeatherData.hourlyForecast.size(); i++) {
                View view = View.inflate(mContext, R.layout.item_hour_info, null);
                mClock[i] = (TextView) view.findViewById(R.id.)
            }

        }

    }







}
