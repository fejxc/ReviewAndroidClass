package com.example.lhy.activityandfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lhy.activityandfragment.R;

/**
 * Created by LHY on 2021/3/17.
 */

    public class CartFragment extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_cart,container,false);
            return view;
        }
}
