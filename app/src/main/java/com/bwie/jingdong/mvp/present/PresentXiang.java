package com.bwie.jingdong.mvp.present;

import android.util.Log;

import com.bwie.jingdong.IView.XiangView;
import com.bwie.jingdong.mvp.model.ModelXiang;
import com.bwie.jingdong.mvp.model.bean.AddCart;
import com.bwie.jingdong.mvp.model.bean.CartsBean;
import com.bwie.jingdong.mvp.model.bean.XiangBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresentXiang extends BasePresent<XiangView> {

    ModelXiang modelXiang;
    XiangView xiangView;

    public PresentXiang(XiangView xiangView){

        this.xiangView=xiangView;
        modelXiang=new ModelXiang();
    }

    public void  getXiang(String pid){

        modelXiang.getXiang(pid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<XiangBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XiangBean xiangBean) {

                       xiangView.success(xiangBean);
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


    //添加购物车
    public void  getaddCart(String uid,String pid,String token){

        modelXiang.getaddCart(uid,pid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AddCart>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddCart addCart) {

                        xiangView.addcartsuccess(addCart.getCode());
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
