package com.bwie.jingdong.IView;

import com.bwie.jingdong.mvp.model.bean.UiBean;

import java.util.List;

public interface IMainView extends IBaseView {

    void onSuccess(List<UiBean.DataBean> list);
    void onErr(String errMsg);

}
