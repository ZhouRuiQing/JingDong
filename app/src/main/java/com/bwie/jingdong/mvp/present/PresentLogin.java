package com.bwie.jingdong.mvp.present;

import com.bwie.jingdong.IView.LoginView;
import com.bwie.jingdong.mvp.model.ModelLogin;
import com.bwie.jingdong.mvp.model.bean.LoginBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresentLogin extends BasePresent<LoginView> {

    ModelLogin modelLogin;
    LoginView loginView;

    public PresentLogin(LoginView loginView){

       this.loginView=loginView;
       modelLogin = new ModelLogin();
    }

    public void getLogin(String mobile ,String password){

        modelLogin.getLogin(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                        loginView.LoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
