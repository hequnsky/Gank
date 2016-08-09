package com.zhq.gank.mvp.news.presenter;

import com.zhq.gank.base.BasePresenterImpl;
import com.zhq.gank.mvp.news.view.NewsDetailView;

/**
 * 作者：hequnsky on 2016/8/4  19:02
 * 邮箱：hequnsky@gmail.com
 */
public class NewsDetailPresenterImpl extends BasePresenterImpl<NewsDetailView> {


    public NewsDetailPresenterImpl(NewsDetailView view){
        attachView(view);
    }
}
