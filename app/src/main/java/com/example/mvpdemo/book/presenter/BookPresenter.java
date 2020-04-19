package com.example.mvpdemo.book.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.example.mvpdemo.book.view.BaseView;
import com.example.mvpdemo.book.view.BookView;
import com.example.mvpdemo.book.model.Book;


public class BookPresenter implements Presenter {

    public BookPresenter(Context ctx) {
        context = ctx;
    }

    private Context context;
    private BookView bookView;


    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(BaseView view) {
        bookView = (BookView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getBook() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bookView.onSuccess(new Book("许三观卖血记"));
            }
        }, 2000);
    }
}
