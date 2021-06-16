package com.example.lhy.viewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView textView;

    private List<String> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        textView = (TextView) findViewById(R.id.tv_index);

//        ImageView imageView = (ImageView) findViewById(R.id.iamgeTest);

        images.add("drawable://"+R.drawable.test01);
        images.add("drawable://"+R.drawable.test02);
        images.add("drawable://"+R.drawable.test03);
        images.add("drawable://"+R.drawable.test04);

        textView.setText("1/"+images.size());
        //初始化适配器
        MyViewPagerAdapter adapter = new MyViewPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                textView.setText((position + 1) + "/" + images.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /*
    * viewPager适配器
    * */

    class MyViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        //初始化视图：container（视图容器），positio（视图位置）
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(MainActivity.this);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);//设置显示样式：填充显示

            ImageLoader.getInstance().displayImage(images.get(position),iv);
            container.addView(iv);

            return iv;
        }

        //移出视图
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
