package com.github.junne.androidweather.modules.launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.github.junne.androidweather.modules.main.ui.HomeActivity;

import java.lang.ref.WeakReference;

/**
 * Created by Junne on 11/23/16.
 */

public class LaunchActivity extends Activity {
    private static final String TAG = LaunchActivity.class.getSimpleName();
    private SwitchHandler mSwitchHandler = new SwitchHandler(Looper.getMainLooper(), this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSwitchHandler.sendEmptyMessageDelayed(1, 1000);
    }

    class SwitchHandler extends Handler {
        private WeakReference<LaunchActivity> mWeakReference;

        public SwitchHandler(Looper mLooper, LaunchActivity activity) {
            super(mLooper);
            mWeakReference = new WeakReference<LaunchActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent i = new Intent(LaunchActivity.this, HomeActivity.class);
            LaunchActivity.this.startActivity(i);

            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            LaunchActivity.this.finish();
        }

    }

}
