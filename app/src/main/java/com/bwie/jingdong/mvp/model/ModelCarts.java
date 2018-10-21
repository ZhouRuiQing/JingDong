package com.bwie.jingdong.mvp.model;

import com.bwie.jingdong.mvp.model.bean.CartsBean;
import com.bwie.jingdong.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class ModelCarts {

    public Observable<CartsBean> getCarts(String uid){

        return HttpUtils.getInstance().api.getCarts(uid);
    }
}
