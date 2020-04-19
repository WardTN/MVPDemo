package com.example.mvpdemo.book.view;

import com.example.mvpdemo.book.model.Book;

public interface BookView extends BaseView {
    void onSuccess(Book mBook);
    void onError(String result);
}
