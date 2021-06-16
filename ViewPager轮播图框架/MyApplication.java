package com.example.lhy.viewpager;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by LHY on 2021/6/2.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //获得初始化事例
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
    }
}
