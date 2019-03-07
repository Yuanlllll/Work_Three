package com.example.work_three;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.work_three.adapter.ShowAdapter;
import com.example.work_three.bean.BannerBean;
import com.example.work_three.bean.ShowBean;
import com.example.work_three.mvp.presenter.PresenterImp;
import com.example.work_three.mvp.view.IView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.x_banner)
    Banner xBanner;
    private ShowBean showBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        PresenterImp presenterImp = new PresenterImp(this);
        presenterImp.getPresenterData();
        presenterImp.getPresenterImageData();
    }

    @Override
    public void getViewData(Object viewData) {
        if (viewData != null) {
            showBean = (ShowBean) viewData;
        }
        Log.i("aaa", "getViewData: " + showBean.getMessage());
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, OrientationHelper.VERTICAL, false));
        recyclerView.setAdapter(new ShowAdapter(MainActivity.this, showBean));
    }

    @Override
    public void getViewImageData(Object viewData) {
        if (viewData != null) {
            BannerBean bannerBean = (BannerBean) viewData;
            if (bannerBean != null) {
                List<BannerBean.ResultBean> list = bannerBean.getResult();
                List<String> list1 = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    String imageUrl = list.get(i).getImageUrl();
                    list1.add(imageUrl);
                }
                xBanner.setDelayTime(2000);
                xBanner.isAutoPlay(true);
                xBanner.setImageLoader(new MyLoader());
                xBanner.setImages(list1)
                        .setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int position) {
                                Toast.makeText(MainActivity.this, "您点击了" + position + "张轮播图", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .start();
            }
        }
    }

    private class MyLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context)
                    .load((String) path)
                    .into(imageView);
        }
    }
}
