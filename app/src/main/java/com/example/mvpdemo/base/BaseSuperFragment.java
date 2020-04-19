package com.example.mvpdemo.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 管理所有Fragment 生命周期 ,如 统计 、恢复
 */
public class BaseSuperFragment extends SupportFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Statsu recovery
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Status save
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
    }
}
