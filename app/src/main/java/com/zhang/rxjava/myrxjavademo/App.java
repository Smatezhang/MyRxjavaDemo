package com.zhang.rxjava.myrxjavademo;

import android.app.Application;
import android.content.Context;

import com.litesuits.orm.*;
import com.litesuits.orm.BuildConfig;
import com.zhang.rxjava.myrxjavademo.util.Toasts;

/**
 * Created by Administrator on 2017/8/12 0012.
 */

public class App extends Application{

    private  static Context sContext;
    private static String Db_NAME;
    private static LiteOrm mLiteOrm;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        sContext = this;
        Toasts.register(this);

        mLiteOrm = LiteOrm.newSingleInstance(this, Db_NAME);

        if(BuildConfig.DEBUG){
            mLiteOrm.setDebugged(true);
        }

    }
}


