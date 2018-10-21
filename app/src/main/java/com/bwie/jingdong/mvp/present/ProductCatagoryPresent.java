package com.bwie.jingdong.mvp.present;

import com.bwie.jingdong.IView.IProductView;
import com.bwie.jingdong.mvp.model.ProductCatagoryModel;
import com.bwie.jingdong.mvp.model.bean.ProductCatagory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductCatagoryPresent extends BasePresent<IProductView> {


    ProductCatagoryModel productCatagoryModel;
    IProductView productView;

    public ProductCatagoryPresent(IProductView productView){

        this.productView =productView;

        productCatagoryModel=new ProductCatagoryModel();
    }

    public void getProduct(String cid){

        productCatagoryModel.getProduct(cid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ProductCatagory>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductCatagory productCatagory) {

                        productView.onSuccess(productCatagory);
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
