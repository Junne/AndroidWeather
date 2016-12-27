package com.github.junne.androidweather.modules.main.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.github.junne.androidweather.R;
import com.github.junne.androidweather.base.BaseFragment;
import com.github.junne.androidweather.modules.main.domain.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Junne on 12/26/16.
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swiprefresh)
    SwipeRefreshLayout mSwiprefresh;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.iv_erro)
    ImageView mIvErro;

    private static Weather mWeather = new Weather();



    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.content_main, container, false);
            ButterKnife.bind(this, view);
        }
        isCreatView = true;
        return view;
    }
}
