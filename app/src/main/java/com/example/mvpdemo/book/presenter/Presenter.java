package com.example.mvpdemo.book.presenter;

import android.content.Intent;

import com.example.mvpdemo.book.view.BaseView;

public interface Presenter {
    void onCreate();

    void onStart();

    void onStop();

    void pause();

    void attachView(BaseView view);

    void attachIncomingIntent(Intent intent);
}
