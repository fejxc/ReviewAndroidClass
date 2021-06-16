package com.example.lhy.activityandfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.lhy.activityandfragment.R;

/**
 * Created by LHY on 2021/3/17.
 */

public class NavigationFragment extends Fragment implements View.OnClickListener {

    private LinearLayout tabItemHome;
    private LinearLayout tabItemCategory;
    private LinearLayout tabItemCart;
    private LinearLayout tabItemPersonal;

    private ImageButton tabItemHomeBtn;
    private ImageButton tabItemCategoryBtn;
    private ImageButton tabItemCartBtn;
    private ImageButton tabItemPersonalBtn;

    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private CartFragment cartFragment;
    private PersonalFragment personalFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation,container,false);

//        初始化
        initView(view);

//        默认显示“首页”模块
        setTabSelection(R.id.tab_item_home);

        return view;
    }

    private void initView(View view){
//        获取线性图标
        tabItemHome = view.findViewById(R.id.tab_item_home);
        tabItemHome.setOnClickListener(this);

        tabItemCategory = view.findViewById(R.id.tab_item_category);
        tabItemCategory.setOnClickListener(this);

        tabItemCart = view.findViewById(R.id.tab_item_cart);
        tabItemCart.setOnClickListener(this);

        tabItemPersonal = view.findViewById(R.id.tab_item_personal);
        tabItemPersonal.setOnClickListener(this);

        tabItemHomeBtn = view.findViewById(R.id.tab_item_home_btn);
        tabItemCategoryBtn = view.findViewById(R.id.tab_item_category_btn);
        tabItemCartBtn = view.findViewById(R.id.tab_item_cart_btn);
        tabItemPersonalBtn = view.findViewById(R.id.tab_item_personal_btn);
    }

    @Override
    public void onClick(View view) {
        setTabSelection(view.getId());
    }

//    设置tab选中
    private void  setTabSelection(int id){
//        重置所有TabItem状态，即所有图片按钮为白色
        tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_focus);
        tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_focus);
        tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_focus);
        tabItemPersonalBtn.setImageResource(R.drawable.tab_item_personal_focus);

//        开启一个事务
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

//        隐藏所有Fragment
        if (homeFragment != null)
            fragmentTransaction.hide(homeFragment);
        if (categoryFragment != null)
            fragmentTransaction.hide(categoryFragment);
        if (cartFragment != null)
            fragmentTransaction.hide(cartFragment);
        if (personalFragment != null)
            fragmentTransaction.hide(personalFragment);

//        根据tabItem的ID选中不同功能
        switch (id){
            case R.id.tab_item_home:
                tabItemHomeBtn.setImageResource(R.drawable.tab_item_home_normal);
                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content,homeFragment);
                }else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.tab_item_category:
                tabItemCategoryBtn.setImageResource(R.drawable.tab_item_category_normal);
                if (categoryFragment == null){
                    categoryFragment = new CategoryFragment();
                    fragmentTransaction.add(R.id.content,categoryFragment);
                }else {
                    fragmentTransaction.show(categoryFragment);
                }
                break;
            case R.id.tab_item_cart:
                tabItemCartBtn.setImageResource(R.drawable.tab_item_cart_normal);
                if (cartFragment == null){
                    cartFragment = new CartFragment();
                    fragmentTransaction.add(R.id.content,cartFragment);
                }else {
                    fragmentTransaction.show(cartFragment);
                }
                break;
            case R.id.tab_item_personal:
                tabItemPersonalBtn.setImageResource(R.drawable.tab_item_personal_normal);
                if (personalFragment == null){
                    personalFragment = new PersonalFragment();
                    fragmentTransaction.add(R.id.content,personalFragment);
                }else {
                    fragmentTransaction.show(personalFragment);
                }
                break;
        }

        fragmentTransaction.commit();
    }
}
