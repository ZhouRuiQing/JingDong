package com.bwie.jingdong.mvp.present;

import com.bwie.jingdong.IView.IRegView;
import com.bwie.jingdong.mvp.model.ModelReg;
import com.bwie.jingdong.mvp.model.bean.UserReg;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresentReg extends BasePresent<IRegView> {

    IRegView iRegView;
    ModelReg modelReg;

    public PresentReg(IRegView iRegView){
        this.iRegView=iRegView;
        modelReg=new ModelReg();
    }

    public void getReg(String mobile,String password){

        modelReg.getReg(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserReg>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserReg userReg) {

                        iRegView.RegSuccess(userReg);
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
