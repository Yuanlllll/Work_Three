package com.example.work_three.network;

import android.util.Log;

import com.example.work_three.api.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private Retrofit retrofit;//单例模式
    private static final class SINGLE_INSTANCE {
        public static final RetrofitUtils _INSTANCE = new RetrofitUtils();
    }

    //方法请求
    public static RetrofitUtils getInstance() {
        return SINGLE_INSTANCE._INSTANCE;
    }

    private RetrofitUtils() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BOTH)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(buildOkhttpClient())
                .build();
        Log.i("aaa", "RetrofitUtils: "+retrofit);
    }

    //设置读写超时
    private OkHttpClient buildOkhttpClient() {
        //添加拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //设置拦截器
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//打印请求参数，请求结果
        //添加拦截器
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(3000,TimeUnit.MILLISECONDS)//连接超时时间
                .writeTimeout(3000, TimeUnit.MILLISECONDS)
                .readTimeout(3000, TimeUnit.MILLISECONDS)
                .build();
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }

    public <T> T create(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
