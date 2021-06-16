package com.example.lhy.activityandfragment.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lhy.activityandfragment.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by LHY on 2021/4/28.
 */

public class AdActivity extends Activity {

    private ImageView adImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        adImageView = findViewById(R.id.ad_image);
        //加载AD
//        String url_ad = "drawable://" +R.drawable.sample_ad;
//        loadAd(url_ad);
        timer();

        Button skipBtn = findViewById(R.id.skip_button);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skip();
            }
        });
    }

    private void skip(){
        startActivity(new Intent(AdActivity.this,MainActivity.class));
    }

    //使用Handler+Thread
    private void timer(){
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == -1)
                    skip();
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(-1);
            }
        }.start();
    }
}
