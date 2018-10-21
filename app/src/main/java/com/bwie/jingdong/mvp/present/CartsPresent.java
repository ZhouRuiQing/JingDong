package com.bwie.jingdong.mvp.present;

import android.util.Log;

import com.bwie.jingdong.IView.ICartsView;
import com.bwie.jingdong.mvp.model.ModelCarts;
import com.bwie.jingdong.mvp.model.bean.CartsBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CartsPresent extends BasePresent<ICartsView> {

    ModelCarts modelCarts;
    ICartsView iCartsView;

    public CartsPresent( ICartsView iCartsView){

        this.iCartsView=iCartsView;
        modelCarts=new ModelCarts();
    }

    public void getCarts(String uid){

        modelCarts.getCarts(uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CartsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartsBean cartsBean) {

                        iCartsView.success(cartsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("xxx",e+"");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
