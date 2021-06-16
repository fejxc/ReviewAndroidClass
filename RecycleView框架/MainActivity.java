package com.example.lhy.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    private ArrayList<String> list;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

//        创建布局管理器
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recycler.setLayoutManager(linearLayoutManager);
//        recycler.setLayoutManager(new GridLayoutManager(this,2));//网格布局
        //瀑布流布局
          recycler.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

//        创建数据源
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("数据"+i);
        }

//        创建适配器
        adapter = new MyAdapter(list);
        recycler.setAdapter(adapter);
    }
}
