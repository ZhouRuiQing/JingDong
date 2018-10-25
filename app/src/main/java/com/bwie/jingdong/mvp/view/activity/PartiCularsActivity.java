package com.bwie.jingdong.mvp.view.activity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.jingdong.IView.XiangView;
import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.XiangBean;
import com.bwie.jingdong.mvp.model.utils.MyLoder;
import com.bwie.jingdong.mvp.present.PresentXiang;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PartiCularsActivity extends AppCompatActivity implements XiangView {


    @BindView(R.id.detail_banner)
    Banner detailBanner;
    @BindView(R.id.detail_price)
    TextView detailPrice;
    @BindView(R.id.detail_title)
    TextView detailTitle;
    @BindView(R.id.AddCart)
    Button AddCart;
    private PresentXiang presentXiang;
    private String pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parti_culars);
        ButterKnife.bind(this);
        int pid = getIntent().getIntExtra("pid", 0);
        presentXiang = new PresentXiang(this);
        presentXiang.getXiang(pid+"");
        // initData();
    }


    @Override
    public void success(XiangBean xiangBean) {

        List<String> imagelist = new ArrayList<>();
        XiangBean.DataBean data = xiangBean.getData();
        pid = String.valueOf(data.getPid());
        String title = data.getTitle();
        double price = data.getPrice();

        String[] split = data.getImages().split("\\|");

        //给对应的条件赋值'
        for (String s : split) {

            imagelist.add(s);
        }

        detailBanner.setImages(imagelist)
                //是否自动轮播
                .isAutoPlay(false)
                .setImageLoader(new MyLoder())
                //设置轮播显示数字
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .start();

        detailPrice.setText("￥" + price);
        detailTitle.setText(title);

    }

    @Override
    public void addcartsuccess(String code) {
        if(code.equals("0")){
            Toast.makeText(this, "添加购物车成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "添加购物车失败", Toast.LENGTH_SHORT).show();
        }
    }


    @SuppressLint("CheckResult")
    @OnClick(R.id.AddCart)
    public void onViewClicked() {

        SharedPreferences user = PartiCularsActivity.this.getSharedPreferences("user", MODE_PRIVATE);
        String token = user.getString("token", "");
        String uid = user.getString("uid", "");
        presentXiang.getaddCart(uid,pid,token);
    }

    /*
    private void initData() {

        String url = getIntent().getStringExtra("url");
        webView.setVisibility(View.VISIBLE);
        webView.loadUrl(url);
    }*/

}
