package com.zhq.gank.mvp.main.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhq.gank.R;
import com.zhq.gank.base.BasePresenterImpl;
import com.zhq.gank.base.extend.MvpFragment;

/**
 * 作者：hequnsky on 2016/8/6 15:56
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class BallFragment extends MvpFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ball, null);
        return view;
    }

    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {

    }
}
