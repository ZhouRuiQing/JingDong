package com.bwie.jingdong.fregment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.bwie.jingdong.IView.HomeView;
import com.bwie.jingdong.IView.IProductView;
import com.bwie.jingdong.R;
import com.bwie.jingdong.apdater.Classifyapdater;
import com.bwie.jingdong.apdater.ExApdater;
import com.bwie.jingdong.apdater.FenLetapdater;
import com.bwie.jingdong.mvp.model.bean.HomeBean;
import com.bwie.jingdong.mvp.model.bean.ProductCatagory;
import com.bwie.jingdong.mvp.present.HomePresent;
import com.bwie.jingdong.mvp.present.ProductCatagoryPresent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFregment extends Fragment implements HomeView,IProductView {


    @BindView(R.id.classify_RecyclerView)
    RecyclerView classifyRecyclerView;
    @BindView(R.id.ExpandableList_View)
    android.widget.ExpandableListView ExpandableListView;
    Unbinder unbinder;
    private HomePresent present;
    private ProductCatagoryPresent productCatagoryPresent;

    public ClassifyFregment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_classify_fregment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        present = new HomePresent(this);
        present.getHome();
        productCatagoryPresent = new ProductCatagoryPresent(this);
        return inflate;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void success(HomeBean homeBean) {

        List<HomeBean.DataBean.FenleiBean> list = homeBean.getData().getFenlei();
        Log.i("aaa",list.size()+"");
        Classifyapdater ifyapdater = new Classifyapdater(getActivity(),list);
        classifyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        classifyRecyclerView.setAdapter(ifyapdater);
        //默认请求cid=1的数据
        productCatagoryPresent.getProduct("1");
        //分类点击回调
        ifyapdater.setOnCatagoryLisenter(new Classifyapdater.OnCatagoryLisenter() {
            @Override
            public void onNameClick(int cid) {
                productCatagoryPresent.getProduct(cid+"");
            }
        });

    }

    @Override
    public void onSuccess(ProductCatagory productCatagory) {

        List<ProductCatagory.DataBean> list = productCatagory.getData();
        Log.i("aaa",list.size()+"");


        if(list.size()==0){

            Toast.makeText(getActivity(),"该分类暂时没有商品",Toast.LENGTH_LONG).show();
        }else{

            ExApdater adapter = new ExApdater(list);

            ExpandableListView.setAdapter(adapter);
            for (int i = 0; i < list.size(); i++) {
                ExpandableListView.expandGroup(i);
            }
        }

    }

    @Override
    public void Error(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
