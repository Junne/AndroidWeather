package com.github.junne.androidweather.modules.main.ui;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.github.junne.androidweather.R;
import com.github.junne.androidweather.base.BaseActivity;

/**
 * Created by Junne on 12/1/16.
 */

public class MainActivity extends BaseActivity  {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
    }
}
