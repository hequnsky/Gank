package com.zhq.gank.callback;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * 作者：hequnsky on 2016/8/3 18:11
 * 邮箱：hequnsky@gmail.com
 */
public class SubscriberCallback<T> extends Subscriber<T> {

    private NetCallback<T> mNetCallback;

    public SubscriberCallback(NetCallback<T> mNetCallback) {
        this.mNetCallback = mNetCallback;
    }

    @Override
    public void onCompleted() {
        mNetCallback.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        int code = 404;
        String msg = "未知错误";
        if (e instanceof HttpException) {
            code = 500;
            msg = "世界最遥远的距离就是没网";
        }
        mNetCallback.onFailer(code, msg);
        mNetCallback.onCompleted();
    }

    @Override
    public void onNext(T t) {
        mNetCallback.onSuccess(t);

    }
}
