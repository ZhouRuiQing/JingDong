package com.bwie.jingdong.mvp.model;

import com.bwie.jingdong.mvp.model.bean.ProductCatagory;
import com.bwie.jingdong.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class ProductCatagoryModel {

    public Observable<ProductCatagory> getProduct(String cid){

         return HttpUtils.getInstance().api.getProduct(cid);
    }
}
