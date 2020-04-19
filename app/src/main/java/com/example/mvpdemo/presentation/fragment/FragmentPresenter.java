package com.example.mvpdemo.presentation.fragment;

import com.example.mvpdemo.mvp.MvpBasePresenter;

public class FragmentPresenter extends MvpBasePresenter<FragmentContract.View> implements FragmentContract.Presenter  {

    private static final String TAG = "FragmentPresenter";

    @Override
    public void start() {
        super.start();
        /**
         * You can init action here
         *
         * 你可以在这里进行一些初始操作
         */
    }
}
