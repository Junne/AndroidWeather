package com.github.junne.androidweather.modules.main.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baijf on 15/01/2017.
 * Email: junnebai@163.com
 */

public class WeatherAPI {

    @SerializedName("HeWeather data service 3.0") @Expose
    public List<Weather> mHeWeatherDataService30s = new ArrayList<>();
}
