package com.zhq.gank.base;

/**
 * 作者：hequnsky on 2016/8/3 15:58
 * 邮箱：hequnsky@gmail.com
 */
public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();



}
