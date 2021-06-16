package com.example.lhy.activityandfragment.common;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by LHY on 2021/4/28.
 */

public class MyApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        //全局配置UIL
        ImageLoader.getInstance();
    }
}
