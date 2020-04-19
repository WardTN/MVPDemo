package com.example.mvpdemo.presentation.fragment.first;

import com.example.mvpdemo.mvp.MvpPresenter;
import com.example.mvpdemo.mvp.MvpView;

public interface FirstContract {

    interface View extends MvpView {

        void setBtnGetDataEnabled(boolean enabled);

        void showData(String data);
    }

    interface Presenter extends MvpPresenter<View> {

        void getData();
    }
}