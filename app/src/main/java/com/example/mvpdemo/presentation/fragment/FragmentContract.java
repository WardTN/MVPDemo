package com.example.mvpdemo.presentation.fragment;

import com.example.mvpdemo.mvp.MvpPresenter;
import com.example.mvpdemo.mvp.MvpView;

public interface FragmentContract {

    interface View extends MvpView {

    }

    interface Presenter extends MvpPresenter<View> {

    }
}