package com.example.lhy.activityandfragment.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lhy.activityandfragment.R;
import com.example.lhy.activityandfragment.fragment.NavigationFragment;

public class MainActivity extends AppCompatActivity {

    private NavigationFragment navigationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

//        加载大容器NavigationFragment
//        开启一个事务，将navigationFragment实例添加activity_base定义的容器中
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        navigationFragment = new NavigationFragment();
        fragmentTransaction.add(R.id.main_frame,navigationFragment).commit();
    }
}
