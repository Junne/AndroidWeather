package com.github.junne.androidweather.common.utils;


import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by baijf on 12/01/2017.
 */

public class RxUtils {

    public static <T>ObservableTransformer<T, T> rxSchedulerHelper() {

//        return tObservable -> tObservable.subscribeOn(Schedulers.io())
//                .unsubscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<T, T> rxSchedulerHelper(final Scheduler scheduler) {
//        return Observable -> Observable.subscribeOn(scheduler)
//                .unsubscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread());
    }

    




}
