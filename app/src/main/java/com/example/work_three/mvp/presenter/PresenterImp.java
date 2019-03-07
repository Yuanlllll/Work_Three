package com.example.work_three.mvp.presenter;

import com.example.work_three.MainActivity;
import com.example.work_three.mvp.model.IModel;
import com.example.work_three.mvp.model.ModelImp;

public class PresenterImp implements IPresenter {
    MainActivity mainActivity;
    private final ModelImp modelImp;

    public PresenterImp(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        modelImp = new ModelImp();
    }

    @Override
    public void getPresenterData() {
        modelImp.getMoedlData(new IModel.ModelInterface() {
            @Override
            public void success(Object o) {
                mainActivity.getViewData(o);
            }

            @Override
            public void onFail(Throwable e) {

            }
        });
    }

    @Override
    public void getPresenterImageData() {
        modelImp.getMoedlImageData(new IModel.ModelInterface() {
            @Override
            public void success(Object o) {
                mainActivity.getViewImageData(o);
            }

            @Override
            public void onFail(Throwable e) {

            }
        });
    }

    /*@Override
    public void getPresenterData() {
        modelImp.getMoedlData(Api.SHOW, ShowBean.class, new IModel.ModelInterface() {
            @Override
            public void success(Object o) {
                mainActivity.getViewData(o);
            }
        });
    }*/

}
