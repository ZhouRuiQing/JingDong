package com.bwie.jingdong.IView;

import com.bwie.jingdong.mvp.model.bean.CartsBean;

public interface ICartsView extends IBaseView {

    void success(CartsBean cartsBean);
    void Error(String msg);
}
