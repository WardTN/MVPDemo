package com.example.mvpdemo.presentation.fragment.second;

import com.example.mvpdemo.mvp.MvpBasePresenter;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;


public class SecondPresenter extends MvpBasePresenter<SecondContract.View> implements SecondContract.Presenter{

    private static final String TAG = "SecondPresenter";

    @Override
    public void start() {
        super.start();
        /**
         * You can init action here
         *
         * 你可以在这里进行一些初始操作
         */
    }

    @Override
    public void getDatas() {
        getView().setRefresh(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isViewAttached()) return;

                List<String> datas = new ArrayList<>();
                for (int i = 0; i < 15; i++) {
                    datas.add("" + i);
                }
                getView().showDatas(datas);
                getView().setRefresh(false);
            }
        }, 2000);
    }
}
