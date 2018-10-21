package com.bwie.jingdong.mvp.present;


import android.util.Log;

import com.bwie.jingdong.IView.HomeView;
import com.bwie.jingdong.mvp.model.HomeModel;
import com.bwie.jingdong.mvp.model.bean.HomeBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public  class HomePresent extends BasePresent<HomeView> {

    HomeModel homeModel;
    HomeView homeView;

    public HomePresent(HomeView homeView){

        this.homeView=homeView;
        homeModel=new HomeModel();
    }

    public void getHome() {

        homeModel.gethome()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {


                        homeView.success(homeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("aaa",e+"");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
