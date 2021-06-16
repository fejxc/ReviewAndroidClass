package com.example.lhy.activityandfragment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by LHY on 2021/4/28.
 */

public class MyWebView extends WebView {
    private IWebViewScroll mIWebViewScroll;
    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //判断当前页面是否处于顶部

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mIWebViewScroll != null && t == 0){
            mIWebViewScroll.onTop();
        }else if (mIWebViewScroll != null && t != 0){
            mIWebViewScroll.notOnTop();
        }
    }

    //设置滑动监听
    public void setOnCustomScrollChanged(IWebViewScroll listener){
        this.mIWebViewScroll = listener;
    }

    //自定义的接口
    public interface IWebViewScroll{
        void onTop();//处于顶部回调
        void notOnTop();
    }
}
