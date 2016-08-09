package com.zhq.gank.mvp.news.view;

import com.zhq.gank.mvp.news.model.NewsModel;

/**
 * 作者：hequnsky on 2016/8/4  16:53
 * 邮箱：hequnsky@gmail.com
 */
public interface NewsListView {
    void showProgress();
    void hideProgress();
    void loadFailer(String msg);
    void addDate(NewsModel data);
}
