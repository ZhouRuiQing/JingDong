package com.bwie.jingdong.mvp.model;

import com.bwie.jingdong.mvp.model.bean.AddCart;
import com.bwie.jingdong.mvp.model.bean.XiangBean;
import com.bwie.jingdong.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class ModelXiang {

    public  Observable<XiangBean> getXiang(String pid){

        return HttpUtils.getInstance().api.getXiang(pid);
    }
    public Observable<AddCart> getaddCart(String uid,String pid,String token){

         return  HttpUtils.getInstance().api.getaddCart(uid, pid, token);
    }
}
