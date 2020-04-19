package com.example.mvpdemo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * 管理所有Activity 生命周期  加上界面栈管理
 */
public class BaseSuperActivity extends SupportActivity {

    private static final String TAG = "BaseSuperActivity";

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Statsu recovery
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Status save
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}