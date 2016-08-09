package com.zhq.gank.mvp.news.view;

/**
 * 作者：hequnsky on 2016/8/4  19:03
 * 邮箱：hequnsky@gmail.com
 */
public interface NewsDetailView {
    void   getDataSuccess();
    void   getDataFailer(String msg);
    void   showProgress();
    void   hideProgress();

}
