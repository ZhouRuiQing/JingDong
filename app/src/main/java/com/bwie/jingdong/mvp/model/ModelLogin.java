package com.bwie.jingdong.mvp.model;

import com.bwie.jingdong.mvp.model.bean.LoginBean;
import com.bwie.jingdong.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class ModelLogin {

    public Observable<LoginBean> getLogin(String mobile,String password){

         return HttpUtils.getInstance().api.getLogin(mobile, password);
    }
}
