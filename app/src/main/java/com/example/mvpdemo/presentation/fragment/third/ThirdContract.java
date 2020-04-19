package com.example.mvpdemo.presentation.fragment.third;

import androidx.annotation.NonNull;

import com.example.mvpdemo.mvp.MvpPresenter;
import com.example.mvpdemo.mvp.MvpView;

import me.yokeyword.fragmentation.SupportFragment;

public interface ThirdContract {

    interface View extends MvpView {

        void setTabContent(@NonNull SupportFragment[] fragments, @NonNull String[] titles);
    }

    interface Presenter extends MvpPresenter<View> {

        void loadData();
    }
}
