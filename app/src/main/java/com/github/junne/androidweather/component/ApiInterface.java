package com.github.junne.androidweather.component;



import com.github.junne.androidweather.modules.main.domain.WeatherAPI;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by baijf on 15/01/2017.
 * Email: junnebai@163.com
 */

public interface ApiInterface {
    String HOST = "https://api.heweather.com/x3/";

    @GET("weather")
    Observable<WeatherAPI> mWeatherAPI(@Query("city") String city, @Query("key") String key);


}
