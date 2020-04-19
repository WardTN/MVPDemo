package com.example.mvpdemo.base;

import android.view.View;

import androidx.annotation.IdRes;

/**
 * 为所有activity封装功能
 */
public class BaseActivity extends BaseSuperActivity {
    private static final String TAG = "BaseActivity";

    public void bindOnClickListener(View rootView,View.OnClickListener listener,@IdRes int... ids)
    {
        for (int id : ids)
        {
            View view = rootView.findViewById(id);
            if (view != null)
            {
                view.setOnClickListener(listener);
            }
        }
    }

    public void bindOnClickLister(View.OnClickListener listener, @IdRes int... ids) {
        for (int id : ids) {
            View view = findViewById(id);
            if (view != null) {
                view.setOnClickListener(listener);
            }
        }
    }

    public void bindOnClickLister(View.OnClickListener listener, View... views) {
        for (View view : views) {
            view.setOnClickListener(listener);
        }
    }
}
