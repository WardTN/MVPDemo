package com.example.mvpdemo.presentation.main;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvpdemo.AppRouter;
import com.example.mvpdemo.book.BookActivity;
import com.example.mvpdemo.R;
import com.example.mvpdemo.mvp.MvpActivity;

public class MainActivity extends MvpActivity<MainContract.Presenter> implements MainContract.View, View.OnClickListener {

    private static final String TAG = "MainActivity";

    private Toolbar mToolbar;
    private Button mBtnGetData;
    private Button mBtnFragment;
    private Button search_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        initView();

        /**
         * Must use
         * 编码规范，必须使用
         */
        getPresenter().start();
    }

    private void initView() {
        mBtnGetData = findViewById(R.id.btn_get_data);
        mBtnFragment = findViewById(R.id.btn_fragment);
        search_book = findViewById(R.id.btn_search_book);
        bindOnClickLister(this, mBtnGetData, mBtnFragment, search_book);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get_data:
                getPresenter().getData();
                break;
            case R.id.btn_fragment:
                AppRouter.showFragmentActivity(this, "Hello MVPFrame Fragment");
                break;
            case R.id.btn_search_book:
                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent);
                break;
        }
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void setBtnGetDataEnabled(boolean enabled) {
        mBtnGetData.setEnabled(enabled);
    }

    @Override
    public void showData(String data) {
        showToast(data);
    }
}
