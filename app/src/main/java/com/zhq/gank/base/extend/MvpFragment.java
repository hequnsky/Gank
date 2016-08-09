package com.zhq.gank.base.extend;

import android.os.Bundle;
import android.view.View;

import com.zhq.gank.base.BaseFragment;
import com.zhq.gank.base.BasePresenterImpl;

/**
 * 作者：hequnsky on 2016/8/3 18:03
 * 邮箱：hequnsky@gmail.com
 */
public abstract class MvpFragment<P extends BasePresenterImpl> extends BaseFragment {

    protected P mvpPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter = createPresenter();

    }

    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
