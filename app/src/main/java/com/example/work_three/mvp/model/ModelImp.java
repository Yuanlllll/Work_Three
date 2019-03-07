package com.example.work_three.mvp.model;

import com.example.work_three.bean.BannerBean;
import com.example.work_three.bean.ShowBean;
import com.example.work_three.network.IRequest;
import com.example.work_three.network.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ModelImp implements IModel {

    @Override
    public void getMoedlData( final ModelInterface modelInterface) {
        //网络请求
        IRequest iRequest = RetrofitUtils.getInstance().create(IRequest.class);
        iRequest.getcommodity()//被观察者
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ShowBean>() {
                    @Override
                    public void onNext(ShowBean value) {
                        modelInterface.success(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelInterface.onFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMoedlImageData(final ModelInterface modelInterface) {
        IRequest iRequest = RetrofitUtils.getInstance().create(IRequest.class);
        iRequest.getImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<BannerBean>() {
                    @Override
                    public void onNext(BannerBean value) {
                        modelInterface.success(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelInterface.onFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
