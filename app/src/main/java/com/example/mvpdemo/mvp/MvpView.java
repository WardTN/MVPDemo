package com.example.mvpdemo.mvp;

import android.content.Context;

import androidx.annotation.StringRes;

public interface MvpView {

    void showToast(String message);

    void showToast(@StringRes int id);

    Context provideContext();

    void loading();

    void succeed();

    void error();

    void empty();

    void complete();
}