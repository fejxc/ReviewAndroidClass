package com.example.lhy.activityandfragment.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lhy.activityandfragment.R;
import com.example.lhy.activityandfragment.activity.MainActivity;
import com.example.lhy.activityandfragment.view.MyWebView;

/**
 * Created by LHY on 2021/3/17.
 */

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private MainActivity mainActivity;
    private TextView searchTV;
    private MyWebView myWebView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        mainActivity = (MainActivity) getActivity();
        //搜索
        searchTV = view.findViewById(R.id.home_search);
        searchTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mainActivity,"等待开发",Toast.LENGTH_LONG).show();
            }
        });
        myWebView = view.findViewById(R.id.webView);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);

        //对MyWebView进行设置
        initMyWebView(view);
        initSwipeRefreshLayout();
        return view;
    }

    //忽略指定的警告
    @SuppressLint("JavascriptInterface")
    private void initMyWebView(View view){
        myWebView.addJavascriptInterface(this,"app");//添加JavaScript接口监听和接口名称
        myWebView.setVerticalScrollBarEnabled(false);//设置无垂直方向的scrollber(滚动条)
        myWebView.setHorizontalScrollBarEnabled(false);//设置无水平方向的scrollber

        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);//启用JS脚本
        settings.setSupportZoom(false);//支持缩放
        settings.setBuiltInZoomControls(false);//启用内置缩放装置

        myWebView.setOnCustomScrollChanged(new MyWebView.IWebViewScroll() {
            @Override
            public void onTop() {
                //处在顶部的时候刷下
                mSwipeRefreshLayout.setEnabled(true);
            }

            @Override
            public void notOnTop() {
                //不在顶部的时候不刷新
                mSwipeRefreshLayout.setEnabled(false);
            }
        });

        //点击后退按钮，让webView后退
        myWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == keyEvent.ACTION_DOWN){
                    if (i == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()){
                        myWebView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });

        //页面加载处理
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Log.e(TAG, "onReceivedError: " );
//                myWebView.loadUrl("file://android_asset/error.html");
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mSwipeRefreshLayout.setRefreshing(true);
                Log.e(TAG, "onPageStarted: " );
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mSwipeRefreshLayout.setRefreshing(false);
                Log.e(TAG, "onPageFinished: " );
                super.onPageFinished(view, url);
            }
        });
        myWebView.loadUrl("https://fejxc.top");
    }

    //对刷新控件进行设置
    private void initSwipeRefreshLayout(){
        mSwipeRefreshLayout.setColorSchemeResources(R.color.RedLight,
                R.color.greenLight,
                R.color.blueLight,
                R.color.yellowLight);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myWebView.reload();
            }
        });
    }
}
