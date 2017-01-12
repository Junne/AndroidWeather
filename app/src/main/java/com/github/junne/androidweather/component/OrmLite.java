package com.github.junne.androidweather.component;

import com.github.junne.androidweather.BuildConfig;
import com.github.junne.androidweather.base.BaseApplication;
import com.github.junne.androidweather.base.C;
import com.litesuits.orm.LiteOrm;

import java.util.Observable;

/**
 * Created by baijf on 12/01/2017.
 */

public class OrmLite {

    static LiteOrm liteOrm;

    public static LiteOrm getInstance() {
        getOrmHolder();
        return liteOrm;
    }

    private static OrmLite getOrmHolder() { return OrmHolder.sInstance; }


    private OrmLite() {
        if (liteOrm == null) {
            liteOrm = LiteOrm.newSingleInstance(BaseApplication.getmAppContext(), C.ORM_NAME);
        }
        liteOrm.setDebugged(BuildConfig.DEBUG);
    }

    private static class OrmHolder {
        private static final OrmLite sInstance = new OrmLite();
    }

//    public static <T> void OrmTest(Class<T> t) {
//        Observable.from(getInstance().query(t))
//                .compose(RxUtils.rx)
//    }




}
