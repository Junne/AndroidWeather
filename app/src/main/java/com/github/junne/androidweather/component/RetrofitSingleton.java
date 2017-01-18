package com.github.junne.androidweather.component;

import com.github.junne.androidweather.BuildConfig;
import com.github.junne.androidweather.base.BaseApplication;
import com.github.junne.androidweather.common.PLog;
import com.github.junne.androidweather.common.ToastUtil;
import com.github.junne.androidweather.common.utils.Util;
import com.github.junne.androidweather.modules.main.domain.CityORM;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by baijf on 15/01/2017.
 * Email: junnebai@163.com
 */

public class RetrofitSingleton {

    private static ApiInterface apiService = null;
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient = null;

    private void init() {
        initOkHttp();
        initRetroift();
        apiService = retrofit.create(ApiInterface.class);
    }

    private static void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File(BaseApplication.cacheDir, "/NetCache");
        Cache cache = new Cache(cacheFile, 1024*1024*50);
        Interceptor cacheInterceptor = chain -> {
            Request request = chain.request();
            if (!Util.isNetworkConnected(BaseApplication.getmAppContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if (Util.isNetworkConnected(BaseApplication.getmAppContext())) {
                int maxAge = 0;
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28;
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        };
        builder.cache(cache).addInterceptor(cacheInterceptor);
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
    }

    private static void initRetroift() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.HOST)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static void disposeFailureInfo(Throwable t) {
        if (t.toString().contains("GaiException") || t.toString().contains("SocketTimeoutException")
                || t.toString().contains("UnknownHostException")) {
            ToastUtil.showShort("网络问题");
        } else if (t.toString().contains("API没有")) {
            OrmLite.getInstance().delete(new WhereBuilder(CityORM.class).where("name=?", Util.replaceInfo(t.getMessage())));
            PLog.w(Util.replaceInfo(t.getMessage()));
            ToastUtil.showShort("错误: " + t.getMessage());
        }

        PLog.w(t.getMessage());
    }

    public ApiInterface getApiService() { return apiService;}

//    public Observable<Weather> fetchWeather(final String city) {
//
//        return apiService.mWeatherAPI(city, C.KEY)
//                .flatMap(weatherAPI -> {
//                    String status = weatherAPI.mHeWeatherDataService30s.get(0).status;
//
//                    if ("no more requests".equals(status)) {
//                        return Observable.error(new RuntimeException("API免费次数已经用完"));
//                    } else if("unknown city".equals(status)) {
//                        return Observable.error(new RuntimeException(String.format("API没有%s", city)));
//                    }
//                    return Observable.just(weatherAPI)
//                })
//                .map(weatherAPI -> weatherAPI.mHeWeatherDataService30s.get(0))
//                .compose(RxUtils.rxSchedulerHelper());
//    }

//    public Observable<VersionAPI> fetchVersion() {
//
//    }








}
