package com.example.work_three.mvp.model;

public interface IModel {
    void getMoedlData(ModelInterface modelInterface);
    void getMoedlImageData(ModelInterface modelInterface);

    public interface ModelInterface {
        void success(Object o);
        void  onFail(Throwable e);
    }
}
