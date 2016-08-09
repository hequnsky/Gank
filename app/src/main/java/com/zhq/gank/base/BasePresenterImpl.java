package com.zhq.gank.base;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 作者：hequnsky on 2016/8/3 16:09
 * 邮箱：hequnsky@gmail.com
 */
public class BasePresenterImpl<V> implements BasePresenter<V> {
    public V View;

    private CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(V view) {
        this.View = view;

    }

    @Override
    public void detachView() {
        this.View = null;
        onUnsubscribe();
    }


    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }

        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }


    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
