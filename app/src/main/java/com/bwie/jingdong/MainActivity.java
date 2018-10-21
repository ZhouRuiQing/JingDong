package com.bwie.jingdong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bwie.jingdong.fregment.ClassifyFregment;
import com.bwie.jingdong.fregment.HomeoPageFregment;
import com.bwie.jingdong.fregment.MyFragment;
import com.bwie.jingdong.fregment.SeekFragment;
import com.bwie.jingdong.fregment.ShopCartFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomBar = findViewById(R.id.bottom_bar);

        mBottomBar.init(getSupportFragmentManager(), 750, 1334)
                  .setImgSize(100, 100)
                  .setFontSize(14)
//                .setTabPadding(10, 6, 4)
//                .setChangeColor(Color.parseColor("#2784E7"),Color.parseColor("#282828"))
                .addTabItem("首页", R.mipmap.ac1, R.mipmap.ac0,HomeoPageFregment.class)
                .addTabItem("分类", R.mipmap.abx, R.mipmap.abw, ClassifyFregment.class)
                .addTabItem("搜索", R.mipmap.abz, R.mipmap.aby, SeekFragment.class)
                .addTabItem("购物车",R.mipmap.abv, R.mipmap.abu, ShopCartFragment.class)
                .addTabItem("我的", R.mipmap.ac3, R.mipmap.ac2, MyFragment.class)
//                .isShowDivider(true)
//                .setDividerColor(Color.parseColor("#373737"))
//                .setTabBarBackgroundColor(Color.parseColor("#FFFFFF"))
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {
                        if (position == 1)
                            mBottomBar.setSpot(1, false);
                    }
                })
                .setSpot(1, true)
                .setSpot(2, true);
    }

    public void setShowTabBar(boolean isShow){
        if (isShow){
            mBottomBar.getTabBar().setVisibility(View.VISIBLE);
        }else {
            mBottomBar.getTabBar().setVisibility(View.GONE);
        }

    }



}
