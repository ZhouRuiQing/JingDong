package com.bwie.jingdong.mvp.present;


import com.bwie.jingdong.IView.IBaseView;

public class BasePresent<V extends IBaseView> {

    private V iv;

    public void attachView(V v) {
        this.iv = v;
    }

    public void dettachView() {
        this.iv = null;
    }

    public V getView(){
        return iv;
    }


}
