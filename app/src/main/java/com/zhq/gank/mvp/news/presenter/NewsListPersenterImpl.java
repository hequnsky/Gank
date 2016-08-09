package com.zhq.gank.mvp.news.presenter;

import com.zhq.gank.base.BasePresenterImpl;
import com.zhq.gank.callback.NetCallback;
import com.zhq.gank.callback.SubscriberCallback;
import com.zhq.gank.common.Api;
import com.zhq.gank.mvp.news.model.NewsModel;
import com.zhq.gank.mvp.news.view.NewsListView;
import com.zhq.gank.network.news.BaozouService;
import com.zhq.gank.network.news.NewsNetwork;

/**
 * 作者：hequnsky on 2016/8/4  16:52
 * 邮箱：hequnsky@gmail.com
 */
public class NewsListPersenterImpl extends BasePresenterImpl<NewsListView> {
    public BaozouService mBaozouService = NewsNetwork.getRetrofit(Api.BAOZOU).create(BaozouService.class);

    public NewsListPersenterImpl(NewsListView newsListView) {
        attachView(newsListView);

    }

    /**
     * 默认加载第一页的数据
     */
    public void loadData(int channels) {
        View.showProgress();
        addSubscription(mBaozouService.getNews(channels), new SubscriberCallback<>(new NetCallback<NewsModel>() {
            @Override
            public void onSuccess(NewsModel model) {
                View.addDate(model);
            }

            @Override
            public void onFailer(int code, String msg) {
                View.loadFailer(msg);
            }

            @Override
            public void onCompleted() {
                View.hideProgress();
            }
        }));

    }

    /**
     * 加载下一页的数据
     */
    public void loadNextData(int channels, int timestamp) {
        View.showProgress();
        addSubscription(mBaozouService.getNextNews(channels, timestamp), new SubscriberCallback<>(new NetCallback <NewsModel>() {
            @Override
            public void onSuccess(NewsModel model) {
                View.addDate(model);
            }

            @Override
            public void onFailer(int code, String msg) {
                View.loadFailer(msg);
            }

            @Override
            public void onCompleted() {
                View.hideProgress();
            }
        }));
    }


}
