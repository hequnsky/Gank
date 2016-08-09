package com.zhq.gank.mvp.photo.view;

import com.zhq.gank.mvp.photo.model.PhotoModel;

/**
 * 作者：hequnsky on 2016/8/4 16:15
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public interface PhotoListView {

    void showProgress();
    void hideProgress();
    void addData(PhotoModel model);
    void loadFailer(String msg);
}
