package com.github.junne.androidweather.modules.main.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.github.junne.androidweather.R;
import com.github.junne.androidweather.base.BaseFragment;
import com.github.junne.androidweather.common.PLog;
import com.github.junne.androidweather.common.utils.SharedPreferenceUtil;
import com.github.junne.androidweather.modules.main.adapter.WeatherAdapter;
import com.github.junne.androidweather.modules.main.domain.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Retrofit;

/**
 * Created by Junne on 12/26/16.
 */

public class MainFragment extends BaseFragment implements AMapLocationListener{

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swiprefresh)
    SwipeRefreshLayout mSwiprefresh;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.iv_erro)
    ImageView mIvErro;

    private static Weather mWeather = new Weather();
    private WeatherAdapter mAdapter;
    private Observer<Weather> observer;

    public AMapLocationClient mLocationClient = null;
    public AMapLocationClientOption mLocationOption = null;

    private View view;

    @Override
    public void onAttach(Context context) { super.onAttach(context);}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.content_main, container, false);
            ButterKnife.bind(this, view);
        }
        isCreatView = true;
        PLog.d("onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        initView();

    }


    private void initView() {
        if (mSwiprefresh != null) {
            mSwiprefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light);
            mSwiprefresh.setOnRefreshListener(
                    () -> mSwiprefresh.postDelayed(this::load, 1000)
            );
        }

        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new WeatherAdapter(mWeather);
        mRecyclerview.setAdapter(mAdapter);
    }

    private Observable<Weather> fetchDataByNetWork() {

        String cityName = SharedPreferenceUtil.getInstance().getCityName();
        return
    }

    private void load() {

    }


}
