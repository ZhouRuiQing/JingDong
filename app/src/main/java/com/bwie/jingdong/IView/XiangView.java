package com.bwie.jingdong.IView;

import com.bwie.jingdong.mvp.model.bean.XiangBean;

public interface XiangView extends IBaseView {

    void success(XiangBean xiangBean);
    void addcartsuccess(String code);
}
