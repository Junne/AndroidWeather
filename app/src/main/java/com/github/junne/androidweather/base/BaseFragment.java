package com.github.junne.androidweather.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import com.trello.rxlifecycle2.components.RxFragment;

/**
 * Created by Junne on 12/26/16.
 */

public abstract class BaseFragment extends RxFragment {

    protected boolean isCreatView = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isCreatView) {
            lazyLoad();
        }
    }

    protected abstract void lazyLoad();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            lazyLoad();
        }
    }

    protected void safeSetTitle(String title) {
        ActionBar appBarLayout = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (appBarLayout != null) {
            appBarLayout.setTitle(title);
        }
    }
}
