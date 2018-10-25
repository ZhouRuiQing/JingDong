package com.bwie.jingdong.mvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

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

public class ProductsActivity extends AppCompatActivity implements XiangView {

    @BindView(R.id.detail_banners)
    Banner detailBanners;
    @BindView(R.id.detail_prices)
    TextView detailPrices;
    @BindView(R.id.detail_titles)
    TextView detailTitles;
    private PresentXiang presentXiang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        presentXiang = new PresentXiang(this);

        initData();


    }

    private void initData() {
        int pscid = getIntent().getIntExtra("pscid", 0);
        presentXiang.getXiang(pscid + "");
    }


    @Override
    public void success(XiangBean xiangBean) {
        List<String> imagelist = new ArrayList<>();
        XiangBean.DataBean data = xiangBean.getData();
        String title = data.getTitle();
        double price = data.getPrice();

        String[] split = data.getImages().split("\\|");

        //给对应的条件赋值'
        for (String s : split) {

            imagelist.add(s);
        }

        detailBanners.setImages(imagelist)
                //是否自动轮播
                .isAutoPlay(false)
                .setImageLoader(new MyLoder())
                //设置轮播显示数字
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .start();

        detailPrices.setText("￥" + price);
        detailTitles.setText(title);
    }

    @Override
    public void addcartsuccess(String code) {

    }
}
