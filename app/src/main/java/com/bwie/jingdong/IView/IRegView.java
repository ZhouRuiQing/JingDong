package com.bwie.jingdong.IView;

import com.bwie.jingdong.mvp.model.bean.UserReg;

public interface IRegView extends IBaseView {

    void RegSuccess(UserReg userReg);
}
