package com.bwie.jingdong.IView;

import com.bwie.jingdong.mvp.model.bean.LoginBean;

public interface LoginView extends IBaseView {

    void LoginSuccess(LoginBean loginBean);
}
