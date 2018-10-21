package com.bwie.jingdong.mvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.jingdong.IView.IProductView;
import com.bwie.jingdong.R;
import com.bwie.jingdong.apdater.ProductsAdapter;
import com.bwie.jingdong.mvp.model.bean.ProductCatagory;
import com.bwie.jingdong.mvp.present.ProductCatagoryPresent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity implements IProductView {

    @BindView(R.id.products_rv)
    RecyclerView productsRv;
    private ProductCatagoryPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        present = new ProductCatagoryPresent(this);

        initData();


    }

    private void initData() {
        int pscid = getIntent().getIntExtra("pscid", 0);
        productsRv.setLayoutManager(new LinearLayoutManager(ProductsActivity.this,LinearLayoutManager.VERTICAL,false));
        present.getProduct(pscid+"");
    }

    @Override
    public void onSuccess(ProductCatagory productCatagory) {

        List<ProductCatagory.DataBean> data = productCatagory.getData();
    }

    @Override
    public void Error(String msg) {

    }
}
