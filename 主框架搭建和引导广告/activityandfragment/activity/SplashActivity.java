package com.example.lhy.activityandfragment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.lhy.activityandfragment.R;

/**
 * Created by LHY on 2021/4/28.
 */

public class SplashActivity extends Activity {

    private ImageView mSplashItem_iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView(){
        mSplashItem_iv = findViewById(R.id.splash_loading_item);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_loading);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this,AdActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashItem_iv.setAnimation(animation);
    }
}
