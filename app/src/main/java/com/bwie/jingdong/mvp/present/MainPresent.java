package com.bwie.jingdong.mvp.present;

import com.bwie.jingdong.IView.IMainView;
import com.bwie.jingdong.mvp.model.MainModel;
import com.bwie.jingdong.mvp.model.bean.UiBean;
import com.bwie.jingdong.mvp.model.utils.HttpUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresent extends BasePresent<IMainView>{

    MainModel mainModel;
    IMainView mainView;


    public MainPresent(IMainView iMainView){

        this.mainView=iMainView;
        mainModel=new MainModel();
    }

    public void getdatas(String key,int page ,String sort){

        Observable<UiBean> getdata = HttpUtils.getInstance().api.getdata(key,page,sort);

        getdata.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UiBean uiBean) {

                        mainView.onSuccess(uiBean.getData());
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
