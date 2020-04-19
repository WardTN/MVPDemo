package com.example.mvpdemo.presentation.fragment.third;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mvpdemo.R;
import com.example.mvpdemo.mvp.MvpFragment;
import com.example.mvpdemo.presentation.fragment.second.SecondAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContentChildFragment extends MvpFragment<ContentChildContract.Presenter> implements ContentChildContract.View, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "ContentChildFragment";
    public static final String K_CONTENT_CHILD = "k_content_child";

    private String mData;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshView;

    private SecondAdapter mAdapter;

    private List<String> mdatas = new ArrayList<>();

    public static ContentChildFragment newInstance(String billId) {
        Bundle args = new Bundle();
        args.putString(ContentChildFragment.K_CONTENT_CHILD, billId);
        ContentChildFragment fragment = new ContentChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_third_content_child;
    }

    private void init() {
        mData = getArguments().getString(K_CONTENT_CHILD);
        Log.d(TAG, "init: " + mData);
        showToast("initChild: " + mData);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initView(view);
        getPresenter().start();
        getPresenter().getDatas();
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler);
        mRefreshView = view.findViewById(R.id.refresh);

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

    @NonNull
    @Override
    public ContentChildContract.Presenter createPresenter() {
        return new ContentChildPresenter();
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
