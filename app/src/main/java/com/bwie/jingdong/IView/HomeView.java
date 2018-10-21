package com.bwie.jingdong.IView;

import com.bwie.jingdong.mvp.model.bean.HomeBean;

import java.util.List;

public interface HomeView  extends IBaseView{

    void success(HomeBean homeBean);
    void Error(String msg);
}
