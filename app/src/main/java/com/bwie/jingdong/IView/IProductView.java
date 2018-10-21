package com.bwie.jingdong.IView;

import com.bwie.jingdong.mvp.model.bean.ProductCatagory;

import java.util.List;

public interface IProductView extends IBaseView {

    void onSuccess(ProductCatagory productCatagory);
    void Error(String msg);
}
