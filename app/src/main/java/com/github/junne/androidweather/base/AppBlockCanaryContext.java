package com.github.junne.androidweather.base;

import com.github.junne.androidweather.BuildConfig;
import com.github.moduth.blockcanary.BlockCanaryContext;

/**
 * Created by baijf on 13/01/2017.
 */

public class AppBlockCanaryContext extends BlockCanaryContext {

    @Override
    public int getConfigBlockThreshold() { return 500;}

    @Override
    public boolean isNeedDisplay() { return BuildConfig.DEBUG;}


    @Override
    public String getLogPath() {
        return "/blockcanary/performance";
    }

}
