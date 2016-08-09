package com.zhq.gank.mvp.main.presenter;

import com.zhq.gank.base.BasePresenterImpl;
import com.zhq.gank.mvp.main.view.MainView;

/**
 * 作者：hequnsky on 2016/8/4  11:38
 * 邮箱：hequnsky@gmail.com
 */
public class MainParsenterImpl extends BasePresenterImpl<MainView> {
    public MainParsenterImpl(MainView mainView) {
        attachView(mainView);

    }

    public void switchNavigation(int id) {
        View.SwitchItem(id);

    }


}
