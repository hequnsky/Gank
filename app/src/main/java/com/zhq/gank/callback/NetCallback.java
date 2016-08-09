package com.zhq.gank.callback;

/**
 * 作者：hequnsky on 2016/8/3 18:09
 * 邮箱：hequnsky@gmail.com
 */
public interface NetCallback<T>{

    void onSuccess(T model);
    void onFailer(int code, String msg);
    void onCompleted();
}
