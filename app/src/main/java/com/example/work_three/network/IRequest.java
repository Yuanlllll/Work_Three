package com.example.work_three.network;

import com.example.work_three.api.Api;
import com.example.work_three.bean.BannerBean;
import com.example.work_three.bean.ShowBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IRequest {
    @GET(Api.SHOW)
    Observable<ShowBean> getcommodity();

    @GET(Api.BANNER)
    Observable<BannerBean> getImage();

}
