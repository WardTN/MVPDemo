package com.example.mvpdemo;

import android.content.Context;

import com.example.mvpdemo.presentation.fragment.FragmentActivity;


public class AppRouter {

    public static void showFragmentActivity(Context context) {
        showFragmentActivity(context, null);
    }

    public static void showFragmentActivity(Context context, String data) {
        context.startActivity(FragmentActivity.newIntent(context, data));
    }
}