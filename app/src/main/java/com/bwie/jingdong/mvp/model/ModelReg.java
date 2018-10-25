package com.bwie.jingdong.mvp.model;

import com.bwie.jingdong.mvp.model.bean.UserReg;
import com.bwie.jingdong.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class ModelReg {

    public  Observable<UserReg>  getReg(String mobile,String password){

      return HttpUtils.getInstance().api.getReg(mobile,password);
    }
}
