package com.bwie.jingdong.mvp.model;

import com.bwie.jingdong.mvp.model.bean.HomeBean;
import com.bwie.jingdong.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class HomeModel {

    public  Observable<HomeBean> gethome(){
        return HttpUtils.getInstance().api.gethome();
    }
}
