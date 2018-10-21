package com.bwie.jingdong.mvp.model;
import com.bwie.jingdong.mvp.model.bean.UiBean;
import com.bwie.jingdong.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;

public class MainModel {

    public void getDatas(String key,int page ,String sort){
        Observable<UiBean> getdata = HttpUtils.getInstance().api.getdata(key, page, sort);
    }

}
