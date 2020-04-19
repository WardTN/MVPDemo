package com.example.mvpdemo.presentation.fragment.third;

import com.example.mvpdemo.mvp.MvpPresenter;
import com.example.mvpdemo.mvp.MvpView;

import java.util.List;

public interface ContentChildContract {

    interface View extends MvpView {

        void setRefresh(boolean refresh);

        void showDatas(List<String> datas);
    }

    interface Presenter extends MvpPresenter<View> {

        void getDatas();
    }
}