package com.example.mvpdemo.presentation.fragment.second;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mvpdemo.R;
import com.example.mvpdemo.mvp.MvpFragment;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends MvpFragment<SecondContract.Presenter> implements SecondContract.View, SwipeRefreshLayout.OnRefreshListener {
    private Toolbar mToolbar;
    private SwipeRefreshLayout mRefreshView;
    private RecyclerView mRecyclerView;

    private SecondAdapter mAdapter;

    private List<String> mdatas = new ArrayList<>();

    public static SecondFragment newInstance() {
        Bundle args = new Bundle();
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**
         * Must use
         * 编码规范，必须使用
         */
        getPresenter().start();

        initView(view);

        /**
         * If you want load data on init
         *
         * 如果你想在初始化的时候加载数据
         */
        // getPresenter().getDatas();
    }

    @NonNull
    @Override
    public SecondContract.Presenter createPresenter() {
        return new SecondPresenter();
    }

    private void initView(View view) {
        mToolbar = view.findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.fragment_second);

        mRefreshView = view.findViewById(R.id.refresh);
        mRecyclerView = view.findViewById(R.id.recycler);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.VERTICAL, false));
        mAdapter = new SecondAdapter(getContext(), mdatas);
        mRecyclerView.setAdapter(mAdapter);

        mRefreshView.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        getPresenter().getDatas();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    public void setRefresh(boolean refresh) {
        mRefreshView.setRefreshing(refresh);
    }

    @Override
    public void showDatas(List<String> datas) {
        mdatas.addAll(datas);
        mAdapter.notifyDataSetChanged();
    }
}
